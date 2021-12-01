package com.liferay.apps.web.internal.info.item.selector;

import com.liferay.apps.manager.model.App;
import com.liferay.info.item.selector.InfoItemSelector;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletMode;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

@Component(service = InfoItemSelector.class)
public class AppInfoItemSelector
	implements InfoItemSelector<App> {

	@Override
	public PortletURL getInfoItemSelectorPortletURL(
			HttpServletRequest httpServletRequest)
		throws Exception {

		PortletURL infoItemSelectorPortletURL =
			PortletProviderUtil.getPortletURL(
				httpServletRequest, App.class.getName(),
				PortletProvider.Action.BROWSE);

		if (infoItemSelectorPortletURL == null) {
			return null;
		}

		ThemeDisplay themeDisplay =
			(ThemeDisplay)httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		infoItemSelectorPortletURL.setParameter(
			"groupId", String.valueOf(themeDisplay.getScopeGroupId()));
		infoItemSelectorPortletURL.setParameter(
			"selectedGroupIds", String.valueOf(themeDisplay.getScopeGroupId()));

		infoItemSelectorPortletURL.setParameter(
			"typeSelection", App.class.getName());
		infoItemSelectorPortletURL.setParameter(
			"showNonindexable", String.valueOf(Boolean.TRUE));
		infoItemSelectorPortletURL.setParameter(
			"showScheduled", String.valueOf(Boolean.TRUE));
		infoItemSelectorPortletURL.setPortletMode(PortletMode.VIEW);
		infoItemSelectorPortletURL.setWindowState(LiferayWindowState.POP_UP);

		return infoItemSelectorPortletURL;
	}

}