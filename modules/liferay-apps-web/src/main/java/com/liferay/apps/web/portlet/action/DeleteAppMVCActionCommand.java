package com.liferay.apps.web.portlet.action;

import com.liferay.apps.manager.model.App;
import com.liferay.apps.manager.service.AppLocalService;
import com.liferay.apps.web.constants.AppManagerPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AppManagerPortletKeys.APP_MANAGER,
                "mvc.command.name=/apps/delete"
        },
        service = MVCActionCommand.class
)
public class DeleteAppMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        long appId = ParamUtil.getLong(actionRequest, "appId");
        App app = appLocalService.fetchApp(appId);
        if (app != null) {
            appLocalService.deleteApp(app);
        }
    }

    @Reference
    private AppLocalService appLocalService;

}
