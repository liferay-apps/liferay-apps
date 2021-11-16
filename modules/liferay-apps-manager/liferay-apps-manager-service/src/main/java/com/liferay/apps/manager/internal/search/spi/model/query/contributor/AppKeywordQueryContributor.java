package com.liferay.apps.manager.internal.search.spi.model.query.contributor;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.liferay.apps.manager.model.App",
        service = KeywordQueryContributor.class
)
public class AppKeywordQueryContributor implements KeywordQueryContributor {

    @Override
    public void contribute(String keywords, BooleanQuery booleanQuery, KeywordQueryContributorHelper keywordQueryContributorHelper) {
        SearchContext searchContext = keywordQueryContributorHelper.getSearchContext();
        _queryHelper.addSearchTerm(booleanQuery, searchContext, Field.CONTENT, false);
        _queryHelper.addSearchTerm(booleanQuery, searchContext, Field.TITLE, false);
        _queryHelper.addSearchTerm(booleanQuery, searchContext, Field.DESCRIPTION, false);
    }

    @Reference
    private QueryHelper _queryHelper;
}
