package com.liferay.apps.web.portlet.action;

import com.liferay.apps.web.constants.AppManagerPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AppManagerPortletKeys.PORTLET_ID,
                "mvc.command.name=/",
                "mvc.command.name=/apps/view"
        },
        service = MVCRenderCommand.class
)
public class ViewMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        return AppManagerPortletKeys.VIEW_JSP;
    }

}
