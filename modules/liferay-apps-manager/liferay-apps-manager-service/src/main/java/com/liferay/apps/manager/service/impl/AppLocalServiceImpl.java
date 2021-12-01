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

import com.liferay.apps.manager.constants.AppsPortletKeys;
import com.liferay.apps.manager.model.App;
import com.liferay.apps.manager.service.base.AppLocalServiceBaseImpl;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.petra.portlet.url.builder.PortletURLBuilder;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalService;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

	public List<App> getApps(long groupId, int start, int end, OrderByComparator obc) {
		return appPersistence.findByGroupId(groupId, start, end, obc);
	}

	public int countApps(long groupId, int status) {
		return appPersistence.countByG_S(groupId, status);
	}

	public List<App> getApps(long groupId, int status) {
		return appPersistence.findByG_S(groupId, status);
	}

	public List<App> getApps(long groupId, int status, int start, int end) {
		return appPersistence.findByG_S(groupId, status, start, end);
	}

	public List<App> getApps(long groupId, int status, int start, int end, OrderByComparator obc) {
		return appPersistence.findByG_S(groupId, status, start, end, obc);
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

		// Workflow
		return startWorkflowInstance(userId, app, serviceContext);
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

		// Workflow
		startWorkflowInstance(userId, app, serviceContext);

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

		_workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(
				app.getCompanyId(), app.getGroupId(), App.class.getName(), app.getAppId());

		return app;
	}

	@Indexable(type = IndexableType.REINDEX)
	public App updateStatus(long userId, long appId, int status, ServiceContext serviceContext,
							Map<String, Serializable> workflowContext) throws PortalException {

		// App

		User user = userLocalService.getUser(userId);
		Date date = new Date();

		App app = appPersistence.findByPrimaryKey(appId);

		app.setStatus(status);
		app.setStatusByUserId(user.getUserId());
		app.setStatusByUserName(user.getFullName());
		app.setStatusDate(serviceContext.getModifiedDate(date));

		app = appLocalService.updateApp(app);

		return app;
	}

	// Resource

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

	// Asset

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

	// Workflow

	private App startWorkflowInstance(long userId, App app, ServiceContext serviceContext) throws PortalException {

		// User portrait
		String userPortraitURL = StringPool.BLANK;
		String userURL = StringPool.BLANK;
		if (serviceContext.getThemeDisplay() != null) {
			User user = userLocalService.getUser(userId);
			userPortraitURL = user.getPortraitURL(serviceContext.getThemeDisplay());
			userURL = user.getDisplayURL(serviceContext.getThemeDisplay());
		}

		Map<String, Serializable> workflowContext =
				HashMapBuilder.<String, Serializable>put(
						WorkflowConstants.CONTEXT_URL,
						getAppUrl(app, serviceContext)
				).put(
						WorkflowConstants.CONTEXT_USER_PORTRAIT_URL, userPortraitURL
				).put(
						WorkflowConstants.CONTEXT_USER_URL, userURL
				).build();

		return WorkflowHandlerRegistryUtil.startWorkflowInstance(
				app.getCompanyId(), app.getGroupId(), userId,
				App.class.getName(), app.getAppId(), app, serviceContext,
				workflowContext);
	}

	private String getAppUrl(App app, ServiceContext serviceContext) {

		String entryURL = GetterUtil.getString(serviceContext.getAttribute("entryURL"));
		if (Validator.isNotNull(entryURL)) {
			return entryURL;
		}

		HttpServletRequest httpServletRequest = serviceContext.getRequest();
		if (httpServletRequest == null) {
			return StringPool.BLANK;
		}

		return PortletURLBuilder.create(
				_portal.getControlPanelPortletURL(
						httpServletRequest, AppsPortletKeys.APP_MANAGER,
						PortletRequest.RENDER_PHASE)
		).setMVCRenderCommandName(
				"/apps/view"
		).setParameter(
				"appId", app.getAppId()
		).buildString();
	}


	@Reference
	private Portal _portal;
	@Reference
	private WorkflowInstanceLinkLocalService _workflowInstanceLinkLocalService;


}