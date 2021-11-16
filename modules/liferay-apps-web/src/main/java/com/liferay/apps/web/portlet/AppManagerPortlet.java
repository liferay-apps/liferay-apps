package com.liferay.apps.web.portlet;

import com.liferay.apps.web.constants.AppManagerPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
			"com.liferay.portlet.add-default-resource=true",
			"com.liferay.portlet.display-category=" + AppManagerPortletKeys.CATEGORY_NAME,
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.display-name=" + AppManagerPortletKeys.DISPLAY_NAME,
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=" + AppManagerPortletKeys.VIEW_JSP,
			"javax.portlet.name=" + AppManagerPortletKeys.APP_MANAGER,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user",
			"com.liferay.portlet.css-class-wrapper=" + AppManagerPortletKeys.CSS_CLASS_WRAPPER,
	},
	service = Portlet.class
)
public class AppManagerPortlet extends MVCPortlet {
}