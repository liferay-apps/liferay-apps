package com.liferay.apps.web.portlet.action;

import com.liferay.apps.manager.service.AppLocalService;
import com.liferay.apps.web.constants.AppManagerPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AppManagerPortletKeys.PORTLET_ID,
                "mvc.command.name=/apps/update"
        },
        service = MVCActionCommand.class
)
public class EditAppMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        try {
            long appId = ParamUtil.getLong(actionRequest, "appId");

            String appName = ParamUtil.getString(actionRequest, "name");
            String appDescription = ParamUtil.getString(actionRequest, "description");
            String iconUrl = ParamUtil.getString(actionRequest, "iconUrl");
            String appLink = ParamUtil.getString(actionRequest, "link");

            long userId = portal.getUserId(actionRequest);
            ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);

            if (appId > 0) {
                // Update
                appLocalService.updateApp(userId, appId, appName, appDescription, iconUrl, appLink, serviceContext);
            } else {
                // Add
                appLocalService.addApp(userId, appName, appDescription, iconUrl, appLink, serviceContext);
            }
        } catch (Exception e) {
            _log.error(e.getMessage(), e);
        }

    }

    @Reference
    private Portal portal;
    @Reference
    private AppLocalService appLocalService;

    private static final Log _log = LogFactoryUtil.getLog(EditAppMVCActionCommand.class);

}
