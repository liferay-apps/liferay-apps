package com.liferay.apps.web.internal.info.item.provider;

import com.liferay.apps.manager.model.App;
import com.liferay.apps.web.internal.info.item.AppInfoItemFields;
import com.liferay.asset.info.item.provider.AssetEntryInfoItemFieldSetProvider;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.expando.info.item.provider.ExpandoInfoItemFieldSetProvider;
import com.liferay.info.field.InfoFieldSet;
import com.liferay.info.form.InfoForm;
import com.liferay.info.item.field.reader.InfoItemFieldReaderFieldSetProvider;
import com.liferay.info.item.provider.InfoItemFormProvider;
import com.liferay.info.localized.InfoLocalizedValue;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.security.permission.ResourceActionsUtil;
import com.liferay.template.info.item.provider.TemplateInfoItemFieldSetProvider;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;
import java.util.Set;

@Component(
	immediate = true, property = Constants.SERVICE_RANKING + ":Integer=10",
	service = InfoItemFormProvider.class
)
public class AppInfoItemFormProvider implements InfoItemFormProvider<App> {

	@Override
	public InfoForm getInfoForm() {
		return _getInfoForm(_assetEntryInfoItemFieldSetProvider.getInfoFieldSet(App.class.getName()));
	}

	@Override
	public InfoForm getInfoForm(App app) {
		try {
			return _getInfoForm(
				_assetEntryInfoItemFieldSetProvider.getInfoFieldSet(
					_assetEntryLocalService.getEntry(App.class.getName(), app.getAppId())));
		}
		catch (PortalException portalException) {
			throw new RuntimeException("Unable to get asset entry for blogs entry " + app.getAppId(), portalException);
		}
	}

	@Override
	public InfoForm getInfoForm(String formVariationKey, long groupId) {
		return _getInfoForm(_assetEntryInfoItemFieldSetProvider.getInfoFieldSet(App.class.getName(), 0, groupId));
	}

	private InfoFieldSet _getBasicInformationInfoFieldSet() {
		return InfoFieldSet.builder(
		).infoFieldSetEntry(
				AppInfoItemFields.appNameInfoField
		).infoFieldSetEntry(
				AppInfoItemFields.appDescriptionInfoField
		).labelInfoLocalizedValue(
			InfoLocalizedValue.localize(
				"com.liferay.journal.lang", "basic-information")
		).name(
			"basic-information"
		).build();
	}


	private InfoForm _getInfoForm(InfoFieldSet assetEntryInfoFieldSet) {
		Set<Locale> availableLocales = LanguageUtil.getAvailableLocales();

		InfoLocalizedValue.Builder infoLocalizedValueBuilder =
			InfoLocalizedValue.builder();

		for (Locale locale : availableLocales) {
			infoLocalizedValueBuilder.value(
				locale,
				ResourceActionsUtil.getModelResource(locale, App.class.getName()));
		}

		return InfoForm.builder(
		).infoFieldSetEntry(
			_getBasicInformationInfoFieldSet()
		).infoFieldSetEntry(
			_expandoInfoItemFieldSetProvider.getInfoFieldSet(App.class.getName())
		).infoFieldSetEntry(
			_templateInfoItemFieldSetProvider.getInfoFieldSet(App.class.getName())
		).infoFieldSetEntry(
			assetEntryInfoFieldSet
		).infoFieldSetEntry(
			_infoItemFieldReaderFieldSetProvider.getInfoFieldSet(App.class.getName())
		).labelInfoLocalizedValue(
			infoLocalizedValueBuilder.build()
		).name(
			App.class.getName()
		).build();
	}

	@Reference
	private AssetEntryInfoItemFieldSetProvider _assetEntryInfoItemFieldSetProvider;
	@Reference
	private AssetEntryLocalService _assetEntryLocalService;
	@Reference
	private ExpandoInfoItemFieldSetProvider _expandoInfoItemFieldSetProvider;
	@Reference
	private InfoItemFieldReaderFieldSetProvider _infoItemFieldReaderFieldSetProvider;
	@Reference
	private TemplateInfoItemFieldSetProvider _templateInfoItemFieldSetProvider;

}