<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
	<c:if test="${not empty result}">
		<div id="project_name">
			<label for="_name">Name:</label>
			<div class="box" id="_name">${result.name}</div>
		</div>
		<br/>
		<div id="project_description">
			<label for="_description">Description:</label>
			<div class="box" id="_description">${result.description}</div>
		</div>
		<br/>
		<div id="project_launchDate">
			<label for="_launchDate">Launch Date:</label>
			<div class="box" id="_launchDate">${result.launchDate}</div>
		</div>
		<br/>
	</c:if>
	<c:if test="${empty result}">No Project found with this id.</c:if>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
