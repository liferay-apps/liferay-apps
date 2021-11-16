package com.liferay.apps.manager.internal.search;

import com.liferay.apps.manager.model.App;
import com.liferay.blogs.model.BlogsEntry;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.liferay.portal.search.spi.model.result.contributor.ModelVisibilityContributor;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = {})
public class AppSearchRegistrar {

    @Activate
    protected void activate(BundleContext bundleContext) {
        _serviceRegistration = _modelSearchRegistrarHelper.register(
                App.class, bundleContext,
                modelSearchDefinition -> {
                    modelSearchDefinition.setDefaultSelectedFieldNames(
                            Field.ASSET_TAG_NAMES, Field.COMPANY_ID, Field.CONTENT,
                            Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK, Field.GROUP_ID,
                            Field.MODIFIED_DATE, Field.SCOPE_GROUP_ID, Field.TITLE, Field.DESCRIPTION, Field.UID);
                    modelSearchDefinition.setDefaultSelectedLocalizedFieldNames(Field.CONTENT, Field.TITLE);
                    modelSearchDefinition.setModelIndexWriteContributor(_modelIndexWriterContributor);
                    modelSearchDefinition.setModelSummaryContributor(_modelSummaryContributor);
                    modelSearchDefinition.setModelVisibilityContributor(_modelVisibilityContributor);
                }
        );
    }

    @Deactivate
    protected void deactivate() {
        _serviceRegistration.unregister();
    }

    @Reference
    private ModelSearchRegistrarHelper _modelSearchRegistrarHelper;
    @Reference(target = "(indexer.class.name=com.liferay.apps.manager.model.App)")
    private ModelIndexerWriterContributor<BlogsEntry> _modelIndexWriterContributor;
    @Reference(target = "(indexer.class.name=com.liferay.apps.manager.model.App)")
    private ModelSummaryContributor _modelSummaryContributor;
    @Reference(target = "(indexer.class.name=com.liferay.apps.manager.model.App)")
    private ModelVisibilityContributor _modelVisibilityContributor;

    private ServiceRegistration<?> _serviceRegistration;
}
