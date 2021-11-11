<%@ include file="/init.jsp" %>

<portlet:renderURL var="cancelUrl">
    <portlet:param name="mvcRenderCommandName" value="/apps/view" />
</portlet:renderURL>
<portlet:actionURL var="updateAppUrl" name="/apps/update"/>

<aui:form action="${updateAppUrl}" method="post" name="fm">
    <aui:input type="hidden" name="appId" value="${app.appId}" />
    <clay:container-fluid>
        <clay:sheet>
            <clay:sheet-header>
                <h2 class="sheet-title">Edit App</h2>
            </clay:sheet-header>
            <clay:sheet-section>
                <aui:input type="text" name="name" required="true" label="app.name" value="${app.name}" />
                <aui:input type="textarea" name="description" label="app.description" value="${app.description}" />
                <aui:input type="text" name="iconUrl" label="app.iconUrl" value="${app.iconUrl}" />
                <aui:input type="text" name="link" required="true" label="app.link" value="${app.link}" />
            </clay:sheet-section>
            <clay:sheet-footer>
                <aui:button href="${cancelUrl}" name="cancelButton" primary="<%= false %>" type="button" value="apps.cancelBtn"  />
                <aui:button name="submitButton" primary="<%= true %>" type="submit" value="apps.saveBtn" />
            </clay:sheet-footer>
        </clay:sheet>
    </clay:container-fluid>
</aui:form>