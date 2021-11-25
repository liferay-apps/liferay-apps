<%@ include file="/init.jsp" %>

<liferay-portlet:renderURL varImpl="iteratorURL" />

<clay:container-fluid cssClass="main-content-body">
    <clay:row>
        <clay:col cssClass="text-center">
            <clay:sheet-header>
                ${app.name}
            </clay:sheet-header>
        </clay:col>
    </clay:row>
    <clay:row>
        <clay:col cssClass="text-center">
            <p>${app.description}</p>
        </clay:col>
    </clay:row>
</clay:container-fluid>