package com.liferay.apps.web.internal.asset.model;

import com.liferay.apps.manager.model.App;
import com.liferay.apps.web.constants.AppWebKeys;
import com.liferay.asset.display.page.portlet.AssetDisplayPageFriendlyURLProvider;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.resource.bundle.ResourceBundleLoader;
import com.liferay.portal.kernel.trash.TrashRenderer;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.ResourceBundle;

public class AppAssetRenderer extends BaseJSPAssetRenderer<App> implements TrashRenderer {

    public AppAssetRenderer(App entry, ResourceBundleLoader resourceBundleLoader) {
        _entry = entry;
        _resourceBundleLoader = resourceBundleLoader;
    }

    @Override
    public App getAssetObject() {
        return _entry;
    }

    @Override
    public String getClassName() {
        return App.class.getName();
    }

    @Override
    public long getClassPK() {
        return _entry.getAppId();
    }

    @Override
    public String getJspPath(HttpServletRequest httpServletRequest, String template) {
        if (template.equals(TEMPLATE_ABSTRACT) || template.equals(TEMPLATE_FULL_CONTENT)) {
            return "/asset/" + template + ".jsp";
        }
        return null;
    }

    @Override
    public String getPortletId() {
        AssetRendererFactory<App> assetRendererFactory = getAssetRendererFactory();
        return assetRendererFactory.getPortletId();
    }

    @Override
    public long getGroupId() {
        return _entry.getGroupId();
    }

    @Override
    public long getUserId() {
        return _entry.getUserId();
    }

    @Override
    public String getUserName() {
        return _entry.getUserName();
    }

    @Override
    public String getUuid() {
        return _entry.getUuid();
    }

    @Override
    public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
        String summary = _entry.getName();
        //todo: prepare summary
        return summary;
    }

    @Override
    public String getTitle(Locale locale) {
        ResourceBundle resourceBundle = _resourceBundleLoader.loadResourceBundle(locale);
        if (Validator.isNull(_entry.getName())) {
            return LanguageUtil.get(resourceBundle, "untitled-entry");
        }
        return _entry.getName();
    }

    @Override
    public String getType() {
        return AppAssetRendererFactory.TYPE;
    }

    @Override
    public boolean include(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String template) throws Exception {
        httpServletRequest.setAttribute(AppWebKeys.APP, _entry);
        return super.include(httpServletRequest, httpServletResponse, template);
    }


    public void setAssetDisplayPageFriendlyURLProvider(AssetDisplayPageFriendlyURLProvider assetDisplayPageFriendlyURLProvider) {
        _assetDisplayPageFriendlyURLProvider = assetDisplayPageFriendlyURLProvider;
    }

    private static final Log _log = LogFactoryUtil.getLog(AppAssetRenderer.class);

    private AssetDisplayPageFriendlyURLProvider _assetDisplayPageFriendlyURLProvider;
    private final App _entry;
    private final ResourceBundleLoader _resourceBundleLoader;
}
