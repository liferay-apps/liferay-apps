package com.liferay.apps.web.internal.info.item.provider;

import com.liferay.apps.manager.model.App;
import com.liferay.info.item.InfoItemClassDetails;
import com.liferay.info.item.InfoItemDetails;
import com.liferay.info.item.InfoItemReference;
import com.liferay.info.item.provider.InfoItemDetailsProvider;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true, property = Constants.SERVICE_RANKING + ":Integer=10",
	service = InfoItemDetailsProvider.class
)
public class AppInfoItemDetailsProvider implements InfoItemDetailsProvider<App> {

	@Override
	public InfoItemClassDetails getInfoItemClassDetails() {
		return new InfoItemClassDetails(App.class.getName());
	}

	@Override
	public InfoItemDetails getInfoItemDetails(App app) {
		return new InfoItemDetails(getInfoItemClassDetails(), new InfoItemReference(App.class.getName(), app.getAppId()));
	}

}