package com.liferay.apps.web.internal.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.apps.web.constants.AppManagerPortletKeys;
import com.liferay.portal.kernel.model.Portlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=300",
		"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
	},
	service = PanelApp.class
)
public class AppsPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return AppManagerPortletKeys.APP_MANAGER;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + AppManagerPortletKeys.APP_MANAGER + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}