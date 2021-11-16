/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.apps.manager.service.impl;

import com.liferay.apps.manager.model.App;
import com.liferay.apps.manager.service.base.AppLocalServiceBaseImpl;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.DateUtil;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author LifeDev
 */
@Component(
	property = "model.class.name=com.liferay.apps.manager.model.App",
	service = AopService.class
)
public class AppLocalServiceImpl extends AppLocalServiceBaseImpl {

	public int countApps(long groupId) {
		return appPersistence.countByGroupId(groupId);
	}

	public List<App> getApps(long groupId) {
		return appPersistence.findByGroupId(groupId);
	}

	public List<App> getApps(long groupId, int start, int end) {
		return appPersistence.findByGroupId(groupId, start, end);
	}

	@Indexable(type = IndexableType.REINDEX)
	public App addApp(long userId, String name, String description, String iconUrl, String link, ServiceContext serviceContext) throws PortalException {

		User user = userLocalService.getUser(userId);
		long groupId = serviceContext.getScopeGroupId();

		long appId = counterLocalService.increment();

		App app = appPersistence.create(appId);

		app.setUserUuid(serviceContext.getUuid());

		app.setGroupId(groupId);
		app.setCompanyId(user.getCompanyId());

		app.setUserId(user.getUserId());
		app.setUserName(user.getFullName());
		app.setCreateDate(serviceContext.getCreateDate());

		app.setName(name);
		app.setDescription(description);
		app.setIconUrl(iconUrl);
		app.setLink(link);

		app = appLocalService.updateApp(app);

		// Resources
		addResources(serviceContext, app);

		// Asset
		updateAsset(userId, serviceContext, app);

		return app;
	}

	@Indexable(type = IndexableType.REINDEX)
	public App updateApp(long userId, long appId, String name, String description, String iconUrl, String link, ServiceContext serviceContext) throws PortalException {

		App app = appPersistence.findByPrimaryKey(appId);
		User user = userLocalService.getUser(userId);

		app.setUserId(user.getUserId());
		app.setUserName(user.getFullName());
		app.setModifiedDate(serviceContext.getModifiedDate(DateUtil.newDate()));

		app.setName(name);
		app.setDescription(description);
		app.setIconUrl(iconUrl);
		app.setLink(link);

		app = appLocalService.updateApp(app);

		// Asset
		updateAsset(userId, serviceContext, app);

		return app;
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public App deleteApp(App app) throws PortalException {

		// App
		appPersistence.remove(app);

		// Resources

		resourceLocalService.deleteResource(
				app.getCompanyId(), App.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, app.getAppId());

		// Asset

		assetEntryLocalService.deleteEntry(App.class.getName(), app.getAppId());

		// Expando

		// Friendly URL

		// Trash

		// Workflow

		return app;
	}



	private void addResources(ServiceContext serviceContext, App app) throws PortalException {
		if (serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()) {
			resourceLocalService.addResources(
					app.getCompanyId(), app.getGroupId(), app.getUserId(),
					App.class.getName(), app.getAppId(), false,
					serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}
		else {
			resourceLocalService.addModelResources(
					app.getCompanyId(), app.getGroupId(), app.getUserId(),
					App.class.getName(), app.getAppId(), serviceContext.getModelPermissions());
		}
	}

	private void updateAsset(long userId, ServiceContext serviceContext, App app) throws PortalException {
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(
				userId, app.getGroupId(), app.getCreateDate(), app.getModifiedDate(), App.class.getName(),
				app.getAppId(), app.getUuid(), 0, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, true, null, null, null,
				null, ContentTypes.TEXT_HTML, app.getName(), app.getDescription(), app.getName(),
				null, null, 0, 0, serviceContext.getAssetPriority()
		);
		assetLinkLocalService.updateLinks(
				userId, assetEntry.getEntryId(), serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);
	}

}