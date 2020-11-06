<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
	<h2>New Project</h2>
	<c:url value="/rest/project" var="action"/>
	<form:form action="${action}" method="POST" modelAttribute="entity">
	<div id="project_nameOfProject">
		<label for="_nameOfProject">NameOfProject:</label>
		<form:input cssStyle="width:300px" id="_nameOfProject" path="nameOfProject"/>
		<br/>
		<form:errors cssClass="errors" id="_nameOfProject" path="nameOfProject"/>
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
