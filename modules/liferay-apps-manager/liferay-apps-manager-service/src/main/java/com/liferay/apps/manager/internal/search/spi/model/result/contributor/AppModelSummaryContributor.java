package com.liferay.apps.manager.internal.search.spi.model.result.contributor;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;

@Component(
        immediate = true,
        property = "indexer.class.name=com.liferay.apps.manager.model.App",
        service = ModelSummaryContributor.class
)
public class AppModelSummaryContributor implements ModelSummaryContributor {

    @Override
    public Summary getSummary(Document document, Locale locale, String snippet) {
        String prefix = Field.SNIPPET + StringPool.UNDERLINE;

        String title = document.get(prefix + Field.TITLE, Field.TITLE);
        String content = document.get(prefix + Field.DESCRIPTION, Field.DESCRIPTION);

        Summary summary = new Summary(title, content);

        summary.setMaxContentLength(200);

        return summary;
    }

}
