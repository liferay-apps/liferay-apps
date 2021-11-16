package com.liferay.apps.web.internal.security.permission.resource;

import com.liferay.apps.manager.model.App;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = AppModelPermission.class)
public class AppModelPermission {

	public static boolean contains(PermissionChecker permissionChecker, App entry, String actionId)
		throws PortalException {
		return appModelResourcePermission.contains(permissionChecker, entry, actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker, long entryId, String actionId) throws PortalException {
		return appModelResourcePermission.contains(permissionChecker, entryId, actionId);
	}

	@Reference(
		target = "(model.class.name=com.liferay.apps.manager.model.App)",
		unbind = "-"
	)
	protected void setEntryModelPermission(ModelResourcePermission<App> modelResourcePermission) {
		appModelResourcePermission = modelResourcePermission;
	}

	private static ModelResourcePermission<App> appModelResourcePermission;
}