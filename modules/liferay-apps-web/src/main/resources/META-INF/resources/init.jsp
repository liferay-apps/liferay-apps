<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/clay" prefix="clay" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.apps.manager.model.App" %>
<%@ page import="com.liferay.portal.kernel.security.permission.ActionKeys" %>
<%@ page import="com.liferay.apps.web.internal.security.permission.resource.AppsPermission" %>
<%@ page import="com.liferay.apps.manager.service.AppLocalServiceUtil" %>
<%@ page import="com.liferay.apps.manager.constants.AppsActionKeys" %>