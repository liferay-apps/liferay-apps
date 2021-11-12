package com.liferay.apps.manager.internal.search;

import com.liferay.apps.manager.model.App;
import com.liferay.portal.kernel.search.BaseSearcher;
import com.liferay.portal.kernel.search.Field;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = "model.class.name=com.liferay.apps.manager.model.App",
        service = BaseSearcher.class
)
public class AppSearcher extends BaseSearcher {

    public AppSearcher() {
        setDefaultSelectedFieldNames(
                Field.ASSET_TAG_NAMES, Field.COMPANY_ID, Field.CONTENT,
                Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK, Field.GROUP_ID,
                Field.MODIFIED_DATE, Field.SCOPE_GROUP_ID, Field.TITLE, Field.DESCRIPTION, Field.UID);
        setFilterSearch(true);
        setPermissionAware(true);
    }

    @Override
    public String getClassName() {
        return _CLASS_NAME;
    }

    private static final String _CLASS_NAME = App.class.getName();

}
