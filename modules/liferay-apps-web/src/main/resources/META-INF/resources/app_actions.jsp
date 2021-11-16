<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.apps.web.internal.security.permission.resource.AppModelPermission" %>
<%@ include file="/init.jsp" %>

<%
    ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
    App appEntry = (App)row.getObject();
    long appId = appEntry.getAppId();
%>
<liferay-ui:icon-menu direction="left-side" icon="" markupView="lexicon" message="actions" showWhenSingleIcon="<%= true %>">
    <%-- Edit --%>
    <c:if test="<%= AppModelPermission.contains(permissionChecker, appId, ActionKeys.UPDATE) %>">
        <portlet:renderURL var="editAppUrl">
            <portlet:param name="mvcRenderCommandName" value="/apps/update" />
            <portlet:param name="appId" value="<%= String.valueOf(appId) %>" />
        </portlet:renderURL>
        <liferay-ui:icon message="action.update" url="${editAppUrl}" />
    </c:if>
    <%-- Delete --%>
    <c:if test="<%= AppModelPermission.contains(permissionChecker, appId, ActionKeys.DELETE) %>">
        <portlet:actionURL var="deleteAppUrl" name="/apps/delete">
            <portlet:param name="appId" value="<%= String.valueOf(appId) %>" />
        </portlet:actionURL>
        <liferay-ui:icon message="action.delete" url="${deleteAppUrl}" />
    </c:if>
    <%-- Permissions --%>
    <c:if test="<%= AppModelPermission.contains(permissionChecker, appId, ActionKeys.PERMISSIONS) %>">
        <liferay-security:permissionsURL
                modelResource="<%= App.class.getName() %>"
                modelResourceDescription="<%= appEntry.getDescription() %>"
                resourcePrimKey="<%= String.valueOf(appId) %>"
                var="permissionsAppURL"
                windowState="<%= LiferayWindowState.POP_UP.toString() %>"
        />
        <liferay-ui:icon message="permissions" method="get" url="<%= permissionsAppURL %>" useDialog="<%= true %>"
        />
    </c:if>
</liferay-ui:icon-menu>