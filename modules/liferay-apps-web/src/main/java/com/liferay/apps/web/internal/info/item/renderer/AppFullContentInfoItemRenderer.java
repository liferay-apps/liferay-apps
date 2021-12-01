package com.liferay.apps.web.internal.info.item.renderer;

import com.liferay.apps.manager.model.App;
import com.liferay.apps.web.constants.AppWebKeys;
import com.liferay.info.item.renderer.InfoItemRenderer;
import com.liferay.portal.kernel.language.LanguageUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Component(
	property = "service.ranking:Integer=300", service = InfoItemRenderer.class
)
public class AppFullContentInfoItemRenderer implements InfoItemRenderer<App> {

	@Override
	public String getLabel(Locale locale) {
		return LanguageUtil.get(locale, "full-content");
	}

	@Override
	public void render(
		App app, HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse) {

		httpServletRequest.setAttribute(AppWebKeys.APP, app);

		RequestDispatcher requestDispatcher =
			_servletContext.getRequestDispatcher(
				"/info/item/renderer/full_content.jsp");

		try {
			requestDispatcher.include(httpServletRequest, httpServletResponse);
		}
		catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}

	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.apps.web)", unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	private ServletContext _servletContext;

}