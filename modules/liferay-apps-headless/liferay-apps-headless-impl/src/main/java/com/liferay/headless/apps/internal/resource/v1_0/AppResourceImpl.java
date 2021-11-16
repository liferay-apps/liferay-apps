package com.liferay.headless.apps.internal.resource.v1_0;

import com.liferay.headless.apps.dto.v1_0.App;
import com.liferay.headless.apps.resource.v1_0.AppResource;

import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Vitaliy Koshelenko
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/app.properties",
	scope = ServiceScope.PROTOTYPE, service = AppResource.class
)
public class AppResourceImpl extends BaseAppResourceImpl {

	@Override
	public Page<App> getApps(String search, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {
		return super.getApps(search, filter, pagination, sorts);
	}
}