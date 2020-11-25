<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
	<h2>Project with this name already exists. Change the project name!</h2>
	<c:url value="/rest/project" var="action"/>
	<form:form action="${action}" method="POST" modelAttribute="entity">
	<div id="project_name">
		<label for="_name">Name:</label>
		<form:input cssStyle="width:300px" id="_name" path="name"/>
		<br/>
		<form:errors cssClass="errors" id="_name" path="name"/>
	</div>
	<div id="project_description">
		<label for="_description">Description:</label>
		<form:input cssStyle="width:300px" id="_description" path="description"/>
		<br/>
		<form:errors cssClass="errors" id="_description" path="description"/>
	</div>
	<div class="submit" id="project_submit">
		<input id="proceed" type="submit" value="Save"/>
	</div>
	</form:form>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>