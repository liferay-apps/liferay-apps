package com.liferay.apps.web.internal.info.item;

import com.liferay.info.field.InfoField;
import com.liferay.info.field.type.ImageInfoFieldType;
import com.liferay.info.field.type.TextInfoFieldType;
import com.liferay.info.localized.InfoLocalizedValue;

public interface AppInfoItemFields {

	InfoField<TextInfoFieldType> appNameInfoField =
		InfoField.builder(
		).infoFieldType(
			TextInfoFieldType.INSTANCE
		).name(
			"appName"
		).labelInfoLocalizedValue(
			InfoLocalizedValue.localize(
					AppInfoItemFields.class, "app-name")
		).build();

	InfoField<ImageInfoFieldType> appDescriptionInfoField = InfoField.builder(
		).infoFieldType(
			ImageInfoFieldType.INSTANCE
		).name(
			"appDescription"
		).labelInfoLocalizedValue(
			InfoLocalizedValue.localize(
					InfoLocalizedValue.class, "app-description")
		).build();

}