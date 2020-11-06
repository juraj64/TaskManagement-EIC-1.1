<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
	<c:if test="${not empty result}">
		<div id="useer_name">
			<label for="_name">Name:</label>
			<div class="box" id="_name">${result.name}</div>
		</div>
		<br/>
		<div id="useer_role">
			<label for="_role">Role:</label>
			<div class="box" id="_role">${result.role}</div>
		</div>
		<br/>
	</c:if>
	<c:if test="${empty result}">No Useer found with this id.</c:if>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
