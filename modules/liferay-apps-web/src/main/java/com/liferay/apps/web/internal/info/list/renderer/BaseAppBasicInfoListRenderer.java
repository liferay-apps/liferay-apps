package com.liferay.apps.web.internal.info.list.renderer;

import com.liferay.apps.manager.model.App;
import com.liferay.blogs.model.BlogsEntry;
import com.liferay.info.item.renderer.InfoItemRenderer;
import com.liferay.info.item.renderer.InfoItemRendererTracker;
import com.liferay.info.list.renderer.DefaultInfoListRendererContext;
import com.liferay.info.list.renderer.InfoListRendererContext;
import com.liferay.info.taglib.list.renderer.BasicInfoListRenderer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public abstract class BaseAppBasicInfoListRenderer implements BasicInfoListRenderer<App> {

	@Override
	public List<InfoItemRenderer<?>> getAvailableInfoItemRenderers() {
		return infoItemRendererTracker.getInfoItemRenderers(
			BlogsEntry.class.getName());
	}

	@Override
	public void render(List<App> apps, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		render(apps,new DefaultInfoListRendererContext(httpServletRequest, httpServletResponse));
	}

	@Override
	public void render(List<App> apps, InfoListRendererContext infoListRendererContext) {

		/*InfoListBasicListTag infoListBasicListTag = new InfoListBasicListTag();

		infoListBasicListTag.setInfoListObjects(apps);

		Optional<String> infoListItemRendererKeyOptional =
			infoListRendererContext.getListItemRendererKeyOptional();

		if (infoListItemRendererKeyOptional.isPresent() &&
			Validator.isNotNull(infoListItemRendererKeyOptional.get())) {

			infoListBasicListTag.setItemRendererKey(
				infoListItemRendererKeyOptional.get());
		}
		else {
			infoListBasicListTag.setItemRendererKey(AppAbstractInfoItemRenderer.class.getName());
		}

		infoListBasicListTag.setListStyleKey(getListStyle());

		try {
			infoListBasicListTag.doTag(
				infoListRendererContext.getHttpServletRequest(),
				infoListRendererContext.getHttpServletResponse());
		}
		catch (Exception exception) {
			_log.error("Unable to render apps list", exception);
		}*/
		//todo:
	}

	@Reference
	protected InfoItemRendererTracker infoItemRendererTracker;

	private static final Log _log = LogFactoryUtil.getLog(BaseAppBasicInfoListRenderer.class);

}