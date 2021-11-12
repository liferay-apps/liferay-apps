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
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
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

		return app;
	}

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

		return app;
	}

	public App deleteApp(App app) throws PortalException {

		// App
		appPersistence.remove(app);

		// Resources

		resourceLocalService.deleteResource(
				app.getCompanyId(), App.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, app.getAppId());

		// Asset

		// Expando

		// Friendly URL

		// Trash

		// Workflow

		return app;
	}

}