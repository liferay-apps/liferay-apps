package com.liferay.apps.web.internal.info.item.provider;

import com.liferay.apps.manager.model.App;
import com.liferay.info.item.capability.InfoItemCapability;
import com.liferay.info.item.provider.InfoItemCapabilitiesProvider;
import com.liferay.layout.page.template.info.item.capability.DisplayPageInfoItemCapability;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.template.info.item.capability.TemplateInfoItemCapability;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(service = InfoItemCapabilitiesProvider.class)
public class AppInfoItemCapabilitiesProvider implements InfoItemCapabilitiesProvider<App> {

	@Override
	public List<InfoItemCapability> getInfoItemCapabilities() {
		return ListUtil.fromArray(_displayPageInfoItemCapability, _templatePageInfoItemCapability);
	}

	@Reference
	private DisplayPageInfoItemCapability _displayPageInfoItemCapability;

	@Reference
	private TemplateInfoItemCapability _templatePageInfoItemCapability;

}