<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
	<c:if test="${not empty result}">
		<div id="deployment_label">
			<label for="_label">Label:</label>
			<div class="box" id="_label">${result.label}</div>
		</div>
		<br/>
		<div id="deployment_date">
			<label for="_date">Date:</label>
			<div class="box" id="_date">${result.date}</div>
		</div>
		<br/>
	</c:if>
	<c:if test="${empty result}">No Deployment found with this id.</c:if>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
