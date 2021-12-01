package com.liferay.apps.web.internal.item.selector;

import com.liferay.apps.manager.model.App;
import com.liferay.apps.manager.service.AppLocalService;
import com.liferay.apps.web.internal.util.AppUtil;
import com.liferay.info.item.selector.InfoItemSelectorView;
import com.liferay.item.selector.ItemSelectorReturnType;
import com.liferay.item.selector.ItemSelectorView;
import com.liferay.item.selector.ItemSelectorViewDescriptor;
import com.liferay.item.selector.ItemSelectorViewDescriptorRenderer;
import com.liferay.item.selector.criteria.InfoItemItemSelectorReturnType;
import com.liferay.item.selector.criteria.info.item.criterion.InfoItemItemSelectorCriterion;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.security.permission.ResourceActionsUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@Component(
	property = "item.selector.view.order:Integer=200",
	service = ItemSelectorView.class
)
public class AppItemSelectorView
	implements InfoItemSelectorView, ItemSelectorView<InfoItemItemSelectorCriterion> {

	@Override
	public String getClassName() {
		return App.class.getName();
	}

	@Override
	public Class<InfoItemItemSelectorCriterion> getItemSelectorCriterionClass() {
		return InfoItemItemSelectorCriterion.class;
	}

	@Override
	public List<ItemSelectorReturnType> getSupportedItemSelectorReturnTypes() {
		return _supportedItemSelectorReturnTypes;
	}

	@Override
	public String getTitle(Locale locale) {
		return _language.get(locale, "apps");
	}

	@Override
	public void renderHTML(
			ServletRequest servletRequest, ServletResponse servletResponse,
			InfoItemItemSelectorCriterion infoItemItemSelectorCriterion,
			PortletURL portletURL, String itemSelectedEventName, boolean search)
		throws IOException, ServletException {

		_itemSelectorViewDescriptorRenderer.renderHTML(
			servletRequest, servletResponse, infoItemItemSelectorCriterion,
			portletURL, itemSelectedEventName, search,
			new AppsItemSelectorViewDescriptor(
				(HttpServletRequest)servletRequest, portletURL));
	}

	private static final List<ItemSelectorReturnType>
		_supportedItemSelectorReturnTypes = Collections.singletonList(
			new InfoItemItemSelectorReturnType());

	@Reference
	private AppLocalService _appLocalService;

	@Reference
	private ItemSelectorViewDescriptorRenderer<InfoItemItemSelectorCriterion>
		_itemSelectorViewDescriptorRenderer;

	@Reference
	private Language _language;

	@Reference
	private Portal _portal;

	private class AppItemDescriptor
		implements ItemSelectorViewDescriptor.ItemDescriptor {

		public AppItemDescriptor(
			App app, HttpServletRequest httpServletRequest) {
			_app = app;
			_httpServletRequest = httpServletRequest;
			_resourceBundle = ResourceBundleUtil.getBundle(
				httpServletRequest.getLocale(), getClass());
		}

		@Override
		public String getIcon() {
			return "apps";
		}

		@Override
		public String getImageURL() {
			/*try {
				ThemeDisplay themeDisplay =
					(ThemeDisplay)_httpServletRequest.getAttribute(
						WebKeys.THEME_DISPLAY);

				String coverImageURL = _blogsEntry.getCoverImageURL(
					themeDisplay);

				if (Validator.isNull(coverImageURL)) {
					return _blogsEntry.getSmallImageURL(themeDisplay);
				}

				return coverImageURL;
			}
			catch (PortalException portalException) {
				return ReflectionUtil.throwException(portalException);
			}*/
			return "";
		}

		@Override
		public Date getModifiedDate() {
			return _app.getModifiedDate();
		}

		@Override
		public String getPayload() {
			ThemeDisplay themeDisplay = (ThemeDisplay)_httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);
			return JSONUtil.put(
				"className", App.class.getName()
			).put(
				"classNameId", _portal.getClassNameId(App.class.getName())
			).put(
				"classPK", _app.getAppId()
			).put(
				"title", AppUtil.getDisplayTitle(_resourceBundle, _app)
			).put(
				"type", ResourceActionsUtil.getModelResource(
					themeDisplay.getLocale(), AppUtil.class.getName())
			).toString();
		}

		@Override
		public String getSubtitle(Locale locale) {
			Date modifiedDate = _app.getModifiedDate();

			String modifiedDateDescription = _language.getTimeDescription(
				locale, System.currentTimeMillis() - modifiedDate.getTime(),
				true);

			return _language.format(
				locale, "x-ago-by-x",
				new Object[] {
					modifiedDateDescription,
					HtmlUtil.escape(_app.getUserName())
				});
		}

		@Override
		public String getTitle(Locale locale) {
			return AppUtil.getDisplayTitle(_resourceBundle, _app);
		}

		@Override
		public long getUserId() {
			return _app.getUserId();
		}

		@Override
		public String getUserName() {
			return _app.getUserName();
		}

		private final App _app;
		private HttpServletRequest _httpServletRequest;
		private final ResourceBundle _resourceBundle;

	}

	private class AppsItemSelectorViewDescriptor
		implements ItemSelectorViewDescriptor<App> {

		public AppsItemSelectorViewDescriptor(
			HttpServletRequest httpServletRequest, PortletURL portletURL) {

			_httpServletRequest = httpServletRequest;
			_portletURL = portletURL;
		}

		@Override
		public ItemDescriptor getItemDescriptor(
			App app) {

			return new AppItemDescriptor(
				app, _httpServletRequest);
		}

		@Override
		public ItemSelectorReturnType getItemSelectorReturnType() {
			return new InfoItemItemSelectorReturnType();
		}

		@Override
		public String[] getOrderByKeys() {
			return new String[] {"name"};
		}

		@Override
		public SearchContainer<App> getSearchContainer() {
			ThemeDisplay themeDisplay =
				(ThemeDisplay)_httpServletRequest.getAttribute(
					WebKeys.THEME_DISPLAY);

			SearchContainer<App> entriesSearchContainer =
				new SearchContainer<>(
					(PortletRequest)_httpServletRequest.getAttribute(
						JavaConstants.JAVAX_PORTLET_REQUEST),
					_portletURL, null, "no-entries-were-found");

			String orderByCol = ParamUtil.getString(
				_httpServletRequest, "orderByCol", "name");

			entriesSearchContainer.setOrderByCol(orderByCol);

			String orderByType = ParamUtil.getString(
				_httpServletRequest, "orderByType", "asc");

			entriesSearchContainer.setOrderByType(orderByType);

			entriesSearchContainer.setOrderByComparator(
				AppUtil.getOrderByComparator(
					entriesSearchContainer.getOrderByCol(),
					entriesSearchContainer.getOrderByType()));

			entriesSearchContainer.setTotal(
					_appLocalService.countApps(
					themeDisplay.getScopeGroupId(),
					WorkflowConstants.STATUS_APPROVED));

			List<App> entriesResults =
				_appLocalService.getApps(
					themeDisplay.getScopeGroupId(),
					WorkflowConstants.STATUS_APPROVED,
					entriesSearchContainer.getStart(),
					entriesSearchContainer.getEnd(),
					entriesSearchContainer.getOrderByComparator());

			entriesSearchContainer.setResults(entriesResults);

			return entriesSearchContainer;
		}

		private HttpServletRequest _httpServletRequest;
		private final PortletURL _portletURL;

	}

}