package com.liferay.apps.web.internal.ratings.definition;

import com.liferay.apps.manager.constants.AppsPortletKeys;
import com.liferay.ratings.kernel.RatingsType;
import com.liferay.ratings.kernel.definition.PortletRatingsDefinition;
import org.osgi.service.component.annotations.Component;

@Component(
	property = "model.class.name=com.liferay.apps.manager.model.App",
	service = PortletRatingsDefinition.class
)
public class AppsPortletRatingsDefinition implements PortletRatingsDefinition {

	@Override
	public RatingsType getDefaultRatingsType() {
		return RatingsType.THUMBS;
	}

	@Override
	public String getPortletId() {
		return AppsPortletKeys.APP_MANAGER;
	}

}