package com.liferay.apps.web.internal.info.item.renderer;

import com.liferay.apps.manager.model.App;
import com.liferay.apps.web.constants.AppWebKeys;
import com.liferay.asset.kernel.AssetRendererFactoryRegistryUtil;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.info.item.renderer.InfoItemRenderer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Component(
	property = "service.ranking:Integer=200", service = InfoItemRenderer.class
)
public class AppAbstractInfoItemRenderer implements InfoItemRenderer<App> {

	@Override
	public String getLabel(Locale locale) {
		return LanguageUtil.get(locale, "abstract");
	}

	@Override
	public void render(
		App entry, HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse) {

		AssetRendererFactory<?> assetRendererFactory =
			AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClass(
				App.class);

		try {
			httpServletRequest.setAttribute(
				WebKeys.ASSET_RENDERER,
				assetRendererFactory.getAssetRenderer(entry.getAppId()));

			httpServletRequest.setAttribute(AppWebKeys.APP, entry);

			RequestDispatcher requestDispatcher =
				_servletContext.getRequestDispatcher("/info/item/renderer/abstract.jsp");

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