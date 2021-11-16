package com.liferay.headless.apps.internal.dto.v1_0.converter;

import com.liferay.headless.apps.dto.v1_0.App;
import com.liferay.portal.vulcan.dto.converter.DTOConverter;
import org.osgi.service.component.annotations.Component;

@Component(
        property = "dto.class.name=com.liferay.apps.manager.model.App",
        service = {AppDTOConverter.class, DTOConverter.class}
)
public class AppDTOConverter implements DTOConverter<com.liferay.apps.manager.model.App, App> {

    @Override
    public String getContentType() {
        return App.class.getSimpleName();
    }

    @Override
    public App toDTO(com.liferay.apps.manager.model.App app) {
        return new App() {
            {
                appId = app.getAppId();
                appName = app.getName();
                appDescription = app.getDescription();
                appLink = app.getLink();
            }
        };
    }
}
