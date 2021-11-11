<%@ include file="/init.jsp" %>

<liferay-portlet:renderURL varImpl="iteratorURL" />

<clay:container-fluid cssClass="main-content-body">
    <clay:row>
        <clay:col cssClass="text-right">
            <portlet:renderURL var="addAppUrl">
                <portlet:param name="mvcRenderCommandName" value="/apps/update" />
            </portlet:renderURL>
            <clay:link displayType="primary" href="${addAppUrl}"
                    type="button"
                    label="action.add"
            />
        </clay:col>
    </clay:row>

    <liferay-ui:search-container total="<%= AppLocalServiceUtil.countApps(scopeGroupId) %>"
                                 delta="10"
                                 emptyResultsMessage="no-apps-found"
                                 iteratorURL="<%=iteratorURL%>">
        <liferay-ui:search-container-results
                results="<%= AppLocalServiceUtil.getApps(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd()) %>"/>
        <liferay-ui:search-container-row className="com.liferay.apps.manager.model.App" modelVar="app" keyProperty="appId">
            <liferay-ui:search-container-column-text name="app.appId" value="${app.appId}" />
            <liferay-ui:search-container-column-text name="app.name" value="${app.name}" />
            <liferay-ui:search-container-column-text name="app.description" value="${app.description}" />
            <liferay-ui:search-container-column-text name="app.iconUrl" value="${app.iconUrl}" />
            <liferay-ui:search-container-column-text name="app.link" value="${app.link}" />
            <liferay-ui:search-container-column-text name="actions.label">
                <liferay-ui:icon-menu direction="left-side" icon="" markupView="lexicon" message="actions" showWhenSingleIcon="<%= true %>">
                    <portlet:renderURL var="editAppUrl">
                        <portlet:param name="mvcRenderCommandName" value="/apps/update" />
                        <portlet:param name="appId" value="${app.appId}" />
                    </portlet:renderURL>
                    <liferay-ui:icon message="action.update" url="${editAppUrl}" />
                    <portlet:actionURL var="deleteAppUrl" name="/apps/delete_app">
                        <portlet:param name="appId" value="${app.appId}" />
                    </portlet:actionURL>
                    <liferay-ui:icon message="action.delete" url="${deleteAppUrl}" />
                </liferay-ui:icon-menu>
            </liferay-ui:search-container-column-text>
        </liferay-ui:search-container-row>
        <liferay-ui:search-iterator markupView="lexicon" />
    </liferay-ui:search-container>

</clay:container-fluid>