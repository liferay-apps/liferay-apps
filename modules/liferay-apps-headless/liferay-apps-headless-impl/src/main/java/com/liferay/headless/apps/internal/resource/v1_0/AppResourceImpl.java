package com.liferay.headless.apps.internal.resource.v1_0;

import com.liferay.apps.manager.service.AppLocalService;
import com.liferay.headless.apps.dto.v1_0.App;
import com.liferay.headless.apps.internal.dto.v1_0.converter.AppDTOConverter;
import com.liferay.headless.apps.resource.v1_0.AppResource;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.List;
import java.util.stream.Collectors;

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
		List<com.liferay.apps.manager.model.App> apps = appLocalService.getApps(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<App> appDtos = apps.stream().map(app -> appDTOConverter.toDTO(app)).collect(Collectors.toList());
		return Page.of(appDtos);
	}


	@Reference
	private AppDTOConverter appDTOConverter;
	@Reference
	private AppLocalService appLocalService;
}