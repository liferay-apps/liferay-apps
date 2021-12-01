package com.liferay.apps.web.internal.info.item.provider;

import com.liferay.apps.manager.model.App;
import com.liferay.apps.web.internal.info.item.AppInfoItemFields;
import com.liferay.asset.display.page.portlet.AssetDisplayPageFriendlyURLProvider;
import com.liferay.asset.info.item.provider.AssetEntryInfoItemFieldSetProvider;
import com.liferay.expando.info.item.provider.ExpandoInfoItemFieldSetProvider;
import com.liferay.info.exception.NoSuchInfoItemException;
import com.liferay.info.field.InfoFieldValue;
import com.liferay.info.item.InfoItemFieldValues;
import com.liferay.info.item.InfoItemReference;
import com.liferay.info.item.field.reader.InfoItemFieldReaderFieldSetProvider;
import com.liferay.info.item.provider.InfoItemFieldValuesProvider;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.template.info.item.provider.TemplateInfoItemFieldSetProvider;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.List;

@Component(
	immediate = true, property = Constants.SERVICE_RANKING + ":Integer=10",
	service = InfoItemFieldValuesProvider.class
)
public class AppInfoItemFieldValuesProvider implements InfoItemFieldValuesProvider<App> {

	@Override
	public InfoItemFieldValues getInfoItemFieldValues(App app) {
		try {
			return InfoItemFieldValues.builder()
					.infoFieldValues(_getAppInfoFieldValues(app))
					.infoFieldValues(_assetEntryInfoItemFieldSetProvider.getInfoFieldValues(App.class.getName(), app.getAppId()))
					.infoFieldValues(_expandoInfoItemFieldSetProvider.getInfoFieldValues(App.class.getName(), app))
					.infoFieldValues(_infoItemFieldReaderFieldSetProvider.getInfoFieldValues(App.class.getName(), app))
					.infoFieldValues(_templateInfoItemFieldSetProvider.getInfoFieldValues(App.class.getName(), app))
					.infoItemReference(new InfoItemReference(App.class.getName(), app.getAppId()))
				.build();
		}
		catch (NoSuchInfoItemException noSuchInfoItemException) {
			throw new RuntimeException("Caught unexpected exception", noSuchInfoItemException);
		}
	}

	private List<InfoFieldValue<Object>> _getAppInfoFieldValues(App app) {
		List<InfoFieldValue<Object>> appFieldValues = new ArrayList<>();
		appFieldValues.add(new InfoFieldValue<>(AppInfoItemFields.appNameInfoField, app.getName()));
		appFieldValues.add(new InfoFieldValue<>(AppInfoItemFields.appDescriptionInfoField, app.getDescription()));
		return appFieldValues;
	}

	private String _getDisplayPageURL(App app) throws PortalException {
		return _assetDisplayPageFriendlyURLProvider.getFriendlyURL(App.class.getName(), app.getAppId(), _getThemeDisplay());
	}

	private ThemeDisplay _getThemeDisplay() {
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		if (serviceContext != null) {
			return serviceContext.getThemeDisplay();
		}
		return null;
	}

	@Reference
	private AssetDisplayPageFriendlyURLProvider _assetDisplayPageFriendlyURLProvider;
	@Reference
	private AssetEntryInfoItemFieldSetProvider _assetEntryInfoItemFieldSetProvider;
	@Reference
	private ExpandoInfoItemFieldSetProvider _expandoInfoItemFieldSetProvider;
	@Reference
	private InfoItemFieldReaderFieldSetProvider _infoItemFieldReaderFieldSetProvider;
	@Reference
	private TemplateInfoItemFieldSetProvider _templateInfoItemFieldSetProvider;

}