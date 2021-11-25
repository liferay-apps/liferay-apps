package com.liferay.apps.web.portlet.action;

import com.liferay.apps.manager.model.App;
import com.liferay.apps.manager.service.AppLocalService;
import com.liferay.apps.web.constants.AppManagerPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AppManagerPortletKeys.APP_MANAGER,
                "mvc.command.name=/",
                "mvc.command.name=/apps/view"
        },
        service = MVCRenderCommand.class
)
public class ViewAppMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        long appId = ParamUtil.getLong(renderRequest, "appId");
        App app = appLocalService.fetchApp(appId);
        renderRequest.setAttribute("app", app);
        return AppManagerPortletKeys.VIEW_JSP;
    }

    @Reference
    private AppLocalService appLocalService;

}
