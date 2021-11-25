package com.liferay.apps.manager.internal.workflow;

import com.liferay.apps.manager.model.App;
import com.liferay.apps.manager.service.AppLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ResourceActionsUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

@Component(
        property = "model.class.name=com.liferay.apps.manager.model.App",
        service = WorkflowHandler.class
)
public class AppWorkflowHandler extends BaseWorkflowHandler<App> {

    @Override
    public String getClassName() {
        return App.class.getName();
    }

    @Override
    public String getType(Locale locale) {
        return ResourceActionsUtil.getModelResource(locale, getClassName());
    }

    @Override
    public App updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
        long userId = GetterUtil.getLong((String)workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
        long appId = GetterUtil.getLong((String)workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
        ServiceContext serviceContext = (ServiceContext)workflowContext.get(WorkflowConstants.CONTEXT_SERVICE_CONTEXT);
        return appLocalService.updateStatus(userId, appId, status, serviceContext, workflowContext);
    }

    @Reference
    private AppLocalService appLocalService;
}
