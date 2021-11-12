package com.liferay.apps.manager.internal.search.spi.model.result.contributor;

import com.liferay.apps.manager.service.AppLocalService;
import com.liferay.portal.search.spi.model.result.contributor.ModelVisibilityContributor;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.liferay.apps.manager.model.App",
        service = ModelVisibilityContributor.class
)
public class AppModelVisibilityContributor implements ModelVisibilityContributor {

    @Override
    public boolean isVisible(long classPK, int status) {
        //todo: check Workflow Status
        return true;
    }

    @Reference
    private AppLocalService appLocalService;
}
