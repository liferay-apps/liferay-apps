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

package com.liferay.apps.manager.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AppLocalService}.
 *
 * @author LifeDev
 * @see AppLocalService
 * @generated
 */
public class AppLocalServiceWrapper
	implements AppLocalService, ServiceWrapper<AppLocalService> {

	public AppLocalServiceWrapper(AppLocalService appLocalService) {
		_appLocalService = appLocalService;
	}

	/**
	 * Adds the app to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param app the app
	 * @return the app that was added
	 */
	@Override
	public com.liferay.apps.manager.model.App addApp(
		com.liferay.apps.manager.model.App app) {

		return _appLocalService.addApp(app);
	}

	@Override
	public com.liferay.apps.manager.model.App addApp(
			long userId, String name, String description, String iconUrl,
			String link,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appLocalService.addApp(
			userId, name, description, iconUrl, link, serviceContext);
	}

	@Override
	public int countApps(long groupId) {
		return _appLocalService.countApps(groupId);
	}

	/**
	 * Creates a new app with the primary key. Does not add the app to the database.
	 *
	 * @param appId the primary key for the new app
	 * @return the new app
	 */
	@Override
	public com.liferay.apps.manager.model.App createApp(long appId) {
		return _appLocalService.createApp(appId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the app from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param app the app
	 * @return the app that was removed
	 */
	@Override
	public com.liferay.apps.manager.model.App deleteApp(
		com.liferay.apps.manager.model.App app) {

		return _appLocalService.deleteApp(app);
	}

	/**
	 * Deletes the app with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appId the primary key of the app
	 * @return the app that was removed
	 * @throws PortalException if a app with the primary key could not be found
	 */
	@Override
	public com.liferay.apps.manager.model.App deleteApp(long appId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appLocalService.deleteApp(appId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _appLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _appLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _appLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _appLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.apps.manager.model.impl.AppModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _appLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.apps.manager.model.impl.AppModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _appLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _appLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _appLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.apps.manager.model.App fetchApp(long appId) {
		return _appLocalService.fetchApp(appId);
	}

	/**
	 * Returns the app matching the UUID and group.
	 *
	 * @param uuid the app's UUID
	 * @param groupId the primary key of the group
	 * @return the matching app, or <code>null</code> if a matching app could not be found
	 */
	@Override
	public com.liferay.apps.manager.model.App fetchAppByUuidAndGroupId(
		String uuid, long groupId) {

		return _appLocalService.fetchAppByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _appLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the app with the primary key.
	 *
	 * @param appId the primary key of the app
	 * @return the app
	 * @throws PortalException if a app with the primary key could not be found
	 */
	@Override
	public com.liferay.apps.manager.model.App getApp(long appId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appLocalService.getApp(appId);
	}

	/**
	 * Returns the app matching the UUID and group.
	 *
	 * @param uuid the app's UUID
	 * @param groupId the primary key of the group
	 * @return the matching app
	 * @throws PortalException if a matching app could not be found
	 */
	@Override
	public com.liferay.apps.manager.model.App getAppByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appLocalService.getAppByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the apps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.apps.manager.model.impl.AppModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of apps
	 * @param end the upper bound of the range of apps (not inclusive)
	 * @return the range of apps
	 */
	@Override
	public java.util.List<com.liferay.apps.manager.model.App> getApps(
		int start, int end) {

		return _appLocalService.getApps(start, end);
	}

	@Override
	public java.util.List<com.liferay.apps.manager.model.App> getApps(
		long groupId) {

		return _appLocalService.getApps(groupId);
	}

	@Override
	public java.util.List<com.liferay.apps.manager.model.App> getApps(
		long groupId, int start, int end) {

		return _appLocalService.getApps(groupId, start, end);
	}

	/**
	 * Returns all the apps matching the UUID and company.
	 *
	 * @param uuid the UUID of the apps
	 * @param companyId the primary key of the company
	 * @return the matching apps, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.liferay.apps.manager.model.App>
		getAppsByUuidAndCompanyId(String uuid, long companyId) {

		return _appLocalService.getAppsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of apps matching the UUID and company.
	 *
	 * @param uuid the UUID of the apps
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of apps
	 * @param end the upper bound of the range of apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching apps, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.liferay.apps.manager.model.App>
		getAppsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.apps.manager.model.App> orderByComparator) {

		return _appLocalService.getAppsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of apps.
	 *
	 * @return the number of apps
	 */
	@Override
	public int getAppsCount() {
		return _appLocalService.getAppsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _appLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _appLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the app in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param app the app
	 * @return the app that was updated
	 */
	@Override
	public com.liferay.apps.manager.model.App updateApp(
		com.liferay.apps.manager.model.App app) {

		return _appLocalService.updateApp(app);
	}

	@Override
	public com.liferay.apps.manager.model.App updateApp(
			long userId, long appId, String name, String description,
			String iconUrl, String link,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appLocalService.updateApp(
			userId, appId, name, description, iconUrl, link, serviceContext);
	}

	@Override
	public AppLocalService getWrappedService() {
		return _appLocalService;
	}

	@Override
	public void setWrappedService(AppLocalService appLocalService) {
		_appLocalService = appLocalService;
	}

	private AppLocalService _appLocalService;

}