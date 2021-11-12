<%@ include file="../init.jsp" %>

<%
    App app = (App)request.getAttribute(AppWebKeys.APP);
    String entryTitle = app.getName();
    String entryDescription = app.getName();
%>

<div class="text-center">
    <h3>Full Content</h3>
    <h1><%= entryTitle %></h1>
    <p>
        <%= entryDescription %>
    </p>
</div>