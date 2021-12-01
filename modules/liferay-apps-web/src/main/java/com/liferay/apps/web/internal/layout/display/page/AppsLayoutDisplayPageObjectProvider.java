package com.liferay.apps.web.internal.layout.display.page;

import com.liferay.apps.manager.model.App;
import com.liferay.asset.kernel.AssetRendererFactoryRegistryUtil;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetTagLocalServiceUtil;
import com.liferay.layout.display.page.LayoutDisplayPageObjectProvider;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.Locale;

public class AppsLayoutDisplayPageObjectProvider
	implements LayoutDisplayPageObjectProvider<App> {

	public AppsLayoutDisplayPageObjectProvider(App app) throws PortalException {
		this._app = app;
		_assetEntry = _getAssetEntry(app);
	}

	@Override
	public long getClassNameId() {
		return _assetEntry.getClassNameId();
	}

	@Override
	public long getClassPK() {
		return _app.getAppId();
	}

	@Override
	public long getClassTypeId() {
		return _assetEntry.getClassTypeId();
	}

	@Override
	public String getDescription(Locale locale) {
		return _assetEntry.getDescription(locale);
	}

	@Override
	public App getDisplayObject() {
		return _app;
	}

	@Override
	public long getGroupId() {
		return _app.getGroupId();
	}

	@Override
	public String getKeywords(Locale locale) {
		String[] assetTagNames = AssetTagLocalServiceUtil.getTagNames(
			_assetEntry.getClassName(), _assetEntry.getClassPK());
		String[] assetCategoryNames =
			AssetCategoryLocalServiceUtil.getCategoryNames(
				_assetEntry.getClassName(), _assetEntry.getClassPK());
		String[] keywords = new String[assetTagNames.length + assetCategoryNames.length];
		ArrayUtil.combine(assetTagNames, assetCategoryNames, keywords);
		return StringUtil.merge(keywords);
	}

	@Override
	public String getTitle(Locale locale) {
		return _assetEntry.getTitle(locale);
	}

	@Override
	public String getURLTitle(Locale locale) {
		AssetRenderer<?> assetRenderer = _assetEntry.getAssetRenderer();
		return assetRenderer.getUrlTitle(locale);
	}

	private AssetEntry _getAssetEntry(App app)
		throws PortalException {
		AssetRendererFactory<?> assetRendererFactory =
			AssetRendererFactoryRegistryUtil.
				getAssetRendererFactoryByClassNameId(PortalUtil.getClassNameId(App.class));
		return assetRendererFactory.getAssetEntry(App.class.getName(), app.getAppId());
	}

	private final AssetEntry _assetEntry;
	private final App _app;

}