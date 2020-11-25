<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
	<h2>User with this name already exists. Change his/her name!</h2>
	<c:url value="/rest/endUser" var="action"/>
	<form:form action="${action}" method="POST" modelAttribute="entity">
	<div id="endUser_name">
		<label for="_name">Name:</label>
		<form:input cssStyle="width:300px" id="_name" path="name"/>
		<br/>
		<form:errors cssClass="errors" id="_name" path="name"/>
	</div>
	<div id="endUser_role">
		<label for="_role">Role:</label>
		<form:input cssStyle="width:300px" id="_role" path="role"/>
		<br/>
		<form:errors cssClass="errors" id="_role" path="role"/>
	</div>
	<div class="submit" id="endUser_submit">
		<input id="proceed" type="submit" value="Save"/>
	</div>
	</form:form>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>