<%@ include file="init.jsp" %>

<div class="asset-summary">
    <h3>Abstract</h3>
    <% AssetRenderer<?> assetRenderer = (AssetRenderer<?>)request.getAttribute(WebKeys.ASSET_RENDERER); %>
    <%= HtmlUtil.stripHtml(assetRenderer.getSummary(renderRequest, renderResponse)) %>
</div>
