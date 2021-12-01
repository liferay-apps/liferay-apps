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

import com.liferay.apps.manager.model.App;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for App. This utility wraps
 * <code>com.liferay.apps.manager.service.impl.AppLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author LifeDev
 * @see AppLocalService
 * @generated
 */
public class AppLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.apps.manager.service.impl.AppLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static App addApp(App app) {
		return getService().addApp(app);
	}

	public static App addApp(
			long userId, String name, String description, String iconUrl,
			String link,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addApp(
			userId, name, description, iconUrl, link, serviceContext);
	}

	public static int countApps(long groupId) {
		return getService().countApps(groupId);
	}

	public static int countApps(long groupId, int status) {
		return getService().countApps(groupId, status);
	}

	/**
	 * Creates a new app with the primary key. Does not add the app to the database.
	 *
	 * @param appId the primary key for the new app
	 * @return the new app
	 */
	public static App createApp(long appId) {
		return getService().createApp(appId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	 * @throws PortalException
	 */
	public static App deleteApp(App app) throws PortalException {
		return getService().deleteApp(app);
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
	public static App deleteApp(long appId) throws PortalException {
		return getService().deleteApp(appId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static App fetchApp(long appId) {
		return getService().fetchApp(appId);
	}

	/**
	 * Returns the app matching the UUID and group.
	 *
	 * @param uuid the app's UUID
	 * @param groupId the primary key of the group
	 * @return the matching app, or <code>null</code> if a matching app could not be found
	 */
	public static App fetchAppByUuidAndGroupId(String uuid, long groupId) {
		return getService().fetchAppByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the app with the primary key.
	 *
	 * @param appId the primary key of the app
	 * @return the app
	 * @throws PortalException if a app with the primary key could not be found
	 */
	public static App getApp(long appId) throws PortalException {
		return getService().getApp(appId);
	}

	/**
	 * Returns the app matching the UUID and group.
	 *
	 * @param uuid the app's UUID
	 * @param groupId the primary key of the group
	 * @return the matching app
	 * @throws PortalException if a matching app could not be found
	 */
	public static App getAppByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getAppByUuidAndGroupId(uuid, groupId);
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
	public static List<App> getApps(int start, int end) {
		return getService().getApps(start, end);
	}

	public static List<App> getApps(long groupId) {
		return getService().getApps(groupId);
	}

	public static List<App> getApps(long groupId, int status) {
		return getService().getApps(groupId, status);
	}

	public static List<App> getApps(long groupId, int start, int end) {
		return getService().getApps(groupId, start, end);
	}

	public static List<App> getApps(
		long groupId, int status, int start, int end) {

		return getService().getApps(groupId, status, start, end);
	}

	public static List<App> getApps(
		long groupId, int status, int start, int end, OrderByComparator obc) {

		return getService().getApps(groupId, status, start, end, obc);
	}

	public static List<App> getApps(
		long groupId, int start, int end, OrderByComparator obc) {

		return getService().getApps(groupId, start, end, obc);
	}

	/**
	 * Returns all the apps matching the UUID and company.
	 *
	 * @param uuid the UUID of the apps
	 * @param companyId the primary key of the company
	 * @return the matching apps, or an empty list if no matches were found
	 */
	public static List<App> getAppsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getAppsByUuidAndCompanyId(uuid, companyId);
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
	public static List<App> getAppsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<App> orderByComparator) {

		return getService().getAppsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of apps.
	 *
	 * @return the number of apps
	 */
	public static int getAppsCount() {
		return getService().getAppsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static App updateApp(App app) {
		return getService().updateApp(app);
	}

	public static App updateApp(
			long userId, long appId, String name, String description,
			String iconUrl, String link,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateApp(
			userId, appId, name, description, iconUrl, link, serviceContext);
	}

	public static App updateStatus(
			long userId, long appId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		return getService().updateStatus(
			userId, appId, status, serviceContext, workflowContext);
	}

	public static AppLocalService getService() {
		return _service;
	}

	private static volatile AppLocalService _service;

}