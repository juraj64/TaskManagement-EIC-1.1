<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
	<h2>New TimeLine</h2>
	<c:url value="/rest/timeLine" var="action"/>
	<form:form action="${action}" method="POST" modelAttribute="entity">
	<div id="timeLine_date">
		<label for="_date">Date:</label>
		<form:input cssStyle="width:300px" id="_date" path="date"/>
		<br/>
		<form:errors cssClass="errors" id="_date" path="date"/>
	</div>
	<div id="timeLine_label">
		<label for="_label">Label:</label>
		<form:input cssStyle="width:300px" id="_label" path="label"/>
		<br/>
		<form:errors cssClass="errors" id="_label" path="label"/>
	</div>
	<div class="submit" id="timeLine_submit">
		<input id="proceed" type="submit" value="Save"/>
	</div>
	</form:form>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
