package com.liferay.apps.manager.internal.search.spi.model.index.contributor;

import com.liferay.apps.manager.model.App;
import com.liferay.apps.manager.service.AppLocalService;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.IndexerWriterMode;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.liferay.apps.manager.model.App",
        service = ModelIndexerWriterContributor.class
)
public class AppModelIndexerWriterContributor implements ModelIndexerWriterContributor<App> {

    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable,
                          ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
        batchIndexingActionable.setPerformActionMethod(
                (App app) -> batchIndexingActionable.addDocuments(modelIndexerWriterDocumentHelper.getDocument(app)));
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return _dynamicQueryBatchIndexingActionableFactory.
                getBatchIndexingActionable(
                        appLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(App app) {
        return app.getCompanyId();
    }

    @Override
    public IndexerWriterMode getIndexerWriterMode(App app) {
        if (app.isApproved() || app.isDraft() ||
                app.isInTrash() || app.isPending()) {
            return IndexerWriterMode.UPDATE;
        }
        if (!app.isApproved() && !app.isInTrash()) {
            return IndexerWriterMode.SKIP;
        }
        return IndexerWriterMode.DELETE;
    }

    @Reference
    private AppLocalService appLocalService;
    @Reference
    private DynamicQueryBatchIndexingActionableFactory _dynamicQueryBatchIndexingActionableFactory;
}
