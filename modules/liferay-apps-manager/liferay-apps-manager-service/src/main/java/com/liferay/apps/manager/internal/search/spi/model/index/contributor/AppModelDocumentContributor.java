package com.liferay.apps.manager.internal.search.spi.model.index.contributor;

import com.liferay.apps.manager.model.App;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = "indexer.class.name=com.liferay.apps.manager.model.App",
        service = ModelDocumentContributor.class
)
public class AppModelDocumentContributor implements ModelDocumentContributor<App> {

    @Override
    public void contribute(Document document, App app) {

        String content = HtmlUtil.extractText(app.getDescription());
        document.addText(Field.CONTENT, content);

        document.addText(Field.TITLE, app.getName());
        document.addText(Field.DESCRIPTION, app.getDescription());
        document.addDate(Field.MODIFIED_DATE, app.getModifiedDate());
    }

}
