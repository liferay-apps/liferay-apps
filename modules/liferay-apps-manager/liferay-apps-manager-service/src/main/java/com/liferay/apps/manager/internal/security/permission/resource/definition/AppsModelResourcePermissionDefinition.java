package com.liferay.apps.manager.internal.security.permission.resource.definition;

import com.liferay.apps.manager.constants.AppsConstants;
import com.liferay.apps.manager.constants.AppsPortletKeys;
import com.liferay.apps.manager.model.App;
import com.liferay.apps.manager.service.AppLocalService;
import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.resource.*;
import com.liferay.portal.kernel.security.permission.resource.definition.ModelResourcePermissionDefinition;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermission;
import com.liferay.sharing.security.permission.resource.SharingModelResourcePermissionConfigurator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicyOption;

import java.util.function.Consumer;

@Component(immediate = true, service = ModelResourcePermissionDefinition.class)
public class AppsModelResourcePermissionDefinition
	implements ModelResourcePermissionDefinition<App> {

	@Override
	public App getModel(long appId) throws PortalException {
		return appLocalService.getApp(appId);
	}

	@Override
	public Class<App> getModelClass() {
		return App.class;
	}

	@Override
	public PortletResourcePermission getPortletResourcePermission() {
		return _portletResourcePermission;
	}

	@Override
	public long getPrimaryKey(App app) {
		return app.getAppId();
	}

	@Override
	public void registerModelResourcePermissionLogics(
		ModelResourcePermission<App> modelResourcePermission,
		Consumer<ModelResourcePermissionLogic<App>>
			modelResourcePermissionLogicConsumer) {

		modelResourcePermissionLogicConsumer.accept(
			new StagedModelPermissionLogic<>(
				_stagingPermission, AppsPortletKeys.APP_MANAGER,
				App::getAppId));
		modelResourcePermissionLogicConsumer.accept(
			new WorkflowedModelPermissionLogic<>(
				_workflowPermission, modelResourcePermission,
				_groupLocalService, App::getAppId));

		if (_sharingModelResourcePermissionConfigurator != null) {
			_sharingModelResourcePermissionConfigurator.configure(
				modelResourcePermission, modelResourcePermissionLogicConsumer);
		}
	}

	@Reference
	private AppLocalService appLocalService;
	@Reference
	private GroupLocalService _groupLocalService;

	@Reference(target = "(resource.name=" + AppsConstants.RESOURCE_NAME + ")")
	private PortletResourcePermission _portletResourcePermission;

	@Reference(
		cardinality = ReferenceCardinality.OPTIONAL,
		policyOption = ReferencePolicyOption.GREEDY
	)
	private volatile SharingModelResourcePermissionConfigurator _sharingModelResourcePermissionConfigurator;

	@Reference
	private StagingPermission _stagingPermission;

	@Reference
	private WorkflowPermission _workflowPermission;

}