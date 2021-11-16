package com.liferay.apps.manager.internal.security.permission.resource.definition;

import com.liferay.apps.manager.constants.AppsConstants;
import com.liferay.apps.manager.constants.AppsPortletKeys;
import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.StagedPortletPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.definition.PortletResourcePermissionDefinition;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true, service = PortletResourcePermissionDefinition.class
)
public class AppsPortletResourcePermissionDefinition implements PortletResourcePermissionDefinition {

	@Override
	public PortletResourcePermissionLogic[] getPortletResourcePermissionLogics() {
		return new PortletResourcePermissionLogic[] {
			new StagedPortletPermissionLogic(_stagingPermission, AppsPortletKeys.APP_MANAGER)
		};
	}

	@Override
	public String getResourceName() {
		return AppsConstants.RESOURCE_NAME;
	}

	@Reference
	private StagingPermission _stagingPermission;

}