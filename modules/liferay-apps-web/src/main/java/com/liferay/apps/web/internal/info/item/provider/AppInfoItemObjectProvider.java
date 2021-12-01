package com.liferay.apps.web.internal.info.item.provider;

import com.liferay.apps.manager.model.App;
import com.liferay.apps.manager.service.AppLocalService;
import com.liferay.info.exception.NoSuchInfoItemException;
import com.liferay.info.item.ClassPKInfoItemIdentifier;
import com.liferay.info.item.GroupUrlTitleInfoItemIdentifier;
import com.liferay.info.item.InfoItemIdentifier;
import com.liferay.info.item.provider.InfoItemObjectProvider;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"info.item.identifier=com.liferay.info.item.ClassPKInfoItemIdentifier",
		"info.item.identifier=com.liferay.info.item.GroupUrlTitleInfoItemIdentifier",
		"service.ranking:Integer=100"
	},
	service = InfoItemObjectProvider.class
)
public class AppInfoItemObjectProvider implements InfoItemObjectProvider<App> {

	@Override
	public App getInfoItem(InfoItemIdentifier infoItemIdentifier)
		throws NoSuchInfoItemException {

		if (!(infoItemIdentifier instanceof ClassPKInfoItemIdentifier) &&
			!(infoItemIdentifier instanceof GroupUrlTitleInfoItemIdentifier)) {
			throw new NoSuchInfoItemException(
				"Unsupported info item identifier type " + infoItemIdentifier);
		}

		App app = null;

		if (infoItemIdentifier instanceof ClassPKInfoItemIdentifier) {
			ClassPKInfoItemIdentifier classPKInfoItemIdentifier =
				(ClassPKInfoItemIdentifier)infoItemIdentifier;

			app = _appLocalService.fetchApp(classPKInfoItemIdentifier.getClassPK());
		}
		else if (infoItemIdentifier instanceof GroupUrlTitleInfoItemIdentifier) {

			GroupUrlTitleInfoItemIdentifier groupURLTitleInfoItemIdentifier =
				(GroupUrlTitleInfoItemIdentifier)infoItemIdentifier;

			app = _appLocalService.fetchAppByUuidAndGroupId(
					groupURLTitleInfoItemIdentifier.getUrlTitle(),
					groupURLTitleInfoItemIdentifier.getGroupId());
		}

		if ((app == null) || app.isDraft() ||
			app.isInTrash()) {

			throw new NoSuchInfoItemException(
				"Unable to get app with info item identifier " +
					infoItemIdentifier);
		}

		return app;
	}

	@Override
	public App getInfoItem(long classPK) throws NoSuchInfoItemException {
		InfoItemIdentifier infoItemIdentifier = new ClassPKInfoItemIdentifier(
			classPK);

		return getInfoItem(infoItemIdentifier);
	}


	@Reference
	private AppLocalService _appLocalService;

}