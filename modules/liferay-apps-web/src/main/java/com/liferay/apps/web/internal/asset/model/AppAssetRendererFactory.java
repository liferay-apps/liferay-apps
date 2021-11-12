package com.liferay.apps.web.internal.asset.model;

import com.liferay.apps.manager.constants.AppsActionKeys;
import com.liferay.apps.manager.constants.AppsConstants;
import com.liferay.apps.manager.model.App;
import com.liferay.apps.manager.service.AppLocalService;
import com.liferay.apps.web.constants.AppManagerPortletKeys;
import com.liferay.asset.display.page.portlet.AssetDisplayPageFriendlyURLProvider;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.resource.bundle.ResourceBundleLoaderUtil;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.util.Portal;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.ServletContext;

@Component(
        immediate = true, property = "javax.portlet.name=" + AppManagerPortletKeys.APP_MANAGER,
        service = AssetRendererFactory.class
)
public class AppAssetRendererFactory extends BaseAssetRendererFactory<App> {

    public static final String TYPE = "app";

    public AppAssetRendererFactory() {
        setClassName(App.class.getName());
        setLinkable(true);
        setPortletId(AppManagerPortletKeys.APP_MANAGER);
        setSearchable(true);
    }

    @Override
    public AssetRenderer<App> getAssetRenderer(long classPK, int type) throws PortalException {
        AppAssetRenderer appAssetRenderer = new AppAssetRenderer(
                appLocalService.getApp(classPK),
                ResourceBundleLoaderUtil.getPortalResourceBundleLoader());
        appAssetRenderer.setAssetDisplayPageFriendlyURLProvider(_assetDisplayPageFriendlyURLProvider);
        appAssetRenderer.setAssetRendererType(type);
        appAssetRenderer.setServletContext(_servletContext);
        return appAssetRenderer;
    }

    @Override
    public String getClassName() {
        return App.class.getName();
    }

    @Override
    public String getIconCssClass() {
        return "blogs";
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public PortletURL getURLView(LiferayPortletResponse liferayPortletResponse, WindowState windowState) {
        LiferayPortletURL liferayPortletURL =
                liferayPortletResponse.createLiferayPortletURL(AppManagerPortletKeys.APP_MANAGER, PortletRequest.RENDER_PHASE);
        try {
            liferayPortletURL.setWindowState(windowState);
        }
        catch (WindowStateException windowStateException) {
            if (_log.isDebugEnabled()) {
                _log.debug(windowStateException, windowStateException);
            }
        }
        return liferayPortletURL;
    }

    @Override
    public boolean hasAddPermission(PermissionChecker permissionChecker, long groupId, long classTypeId) {
        return _portletResourcePermission.contains(permissionChecker, groupId, AppsActionKeys.ADD_APP);
    }

    @Override
    public boolean hasPermission(PermissionChecker permissionChecker, long classPK, String actionId) throws Exception {
        return _appModelResourcePermission.contains(permissionChecker, classPK, actionId);
    }

    private static final Log _log = LogFactoryUtil.getLog(AppAssetRendererFactory.class);

    @Reference
    private AssetDisplayPageFriendlyURLProvider _assetDisplayPageFriendlyURLProvider;

    @Reference
    private AppLocalService appLocalService;

    @Reference(target = "(model.class.name=com.liferay.apps.manager.model.App)")
    private ModelResourcePermission<App> _appModelResourcePermission;

    @Reference
    private Portal _portal;

    @Reference(target = "(resource.name=" + AppsConstants.RESOURCE_NAME + ")")
    private PortletResourcePermission _portletResourcePermission;

    @Reference(target = "(osgi.web.symbolicname=com.liferay.apps.web)")
    private ServletContext _servletContext;
}
