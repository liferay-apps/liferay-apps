package com.liferay.apps.web.internal.info.item.provider;

import com.liferay.apps.manager.model.App;
import com.liferay.info.exception.InfoItemPermissionException;
import com.liferay.info.item.InfoItemReference;
import com.liferay.info.item.provider.InfoItemPermissionProvider;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = InfoItemPermissionProvider.class)
public class AppInfoItemPermissionProvider implements InfoItemPermissionProvider<App> {

	@Override
	public boolean hasPermission(
			PermissionChecker permissionChecker, App app,
			String actionId)
		throws InfoItemPermissionException {

		return _hasPermission(
			permissionChecker, app.getAppId(), actionId);
	}

	@Override
	public boolean hasPermission(
			PermissionChecker permissionChecker,
			InfoItemReference infoItemReference, String actionId)
		throws InfoItemPermissionException {

		return _hasPermission(
			permissionChecker, infoItemReference.getClassPK(), actionId);
	}

	private boolean _hasPermission(
			PermissionChecker permissionChecker, long resourcePrimKey,
			String actionId)
		throws InfoItemPermissionException {

		try {
			return _appModelResourcePermission.contains(
				permissionChecker, resourcePrimKey, actionId);
		}
		catch (PortalException portalException) {
			throw new InfoItemPermissionException(
				resourcePrimKey, portalException);
		}
	}

	@Reference(target = "(model.class.name=com.liferay.apps.manager.model.App)")
	private ModelResourcePermission<App> _appModelResourcePermission;

}