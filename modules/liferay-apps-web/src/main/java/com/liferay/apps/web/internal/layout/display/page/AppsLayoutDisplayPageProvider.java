package com.liferay.apps.web.internal.layout.display.page;

import com.liferay.apps.manager.model.App;
import com.liferay.apps.manager.service.AppLocalService;
import com.liferay.info.item.InfoItemReference;
import com.liferay.layout.display.page.LayoutDisplayPageObjectProvider;
import com.liferay.layout.display.page.LayoutDisplayPageProvider;
import com.liferay.portal.kernel.exception.PortalException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = LayoutDisplayPageProvider.class)
public class AppsLayoutDisplayPageProvider
	implements LayoutDisplayPageProvider<App> {

	@Override
	public String getClassName() {
		return App.class.getName();
	}

	@Override
	public LayoutDisplayPageObjectProvider<App>
		getLayoutDisplayPageObjectProvider(InfoItemReference infoItemReference) {

		try {
			App app = _appLocalService.getApp(infoItemReference.getClassPK());
			if (app.isDraft() || app.isInTrash()) {
				return null;
			}
			return new AppsLayoutDisplayPageObjectProvider(app);
		}
		catch (PortalException portalException) {
			throw new RuntimeException(portalException);
		}
	}

	@Override
	public LayoutDisplayPageObjectProvider<App>
		getLayoutDisplayPageObjectProvider(long groupId, String urlTitle) {

		try {
			//App app = _appLocalService.getApp(groupId, );
			App app = null;//todo:
			if (app.isInTrash()) {
				return null;
			}
			return new AppsLayoutDisplayPageObjectProvider(app);
		}
		catch (PortalException portalException) {
			throw new RuntimeException(portalException);
		}
	}

	@Override
	public String getURLSeparator() {
		return "/a/";
	}

	@Reference
	private AppLocalService _appLocalService;

}