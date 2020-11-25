<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
	<h2>No user with this name in DB. Try again!</h2>
	<p>Please enter correct current task environment: DEV or TEST</p>
	<p>Task must be in status: Resolved</p>
	<c:url value="/rest/deployment/addtask" var="action"/>
	<form:form action="${action}" method="POST" modelAttribute="entity">
	<div id="task_name">
		<label for="_name">Task Name:</label>
		<form:input cssStyle="width:300px" id="_name" path="name"/>
		<br/>
		<form:errors cssClass="errors" id="_name" path="name"/>
	</div>
	<div id="task_placement">
    		<label for="_placement">Environment:</label>
    		<form:input cssStyle="width:300px" id="_placement" path="placement"/>
    		<br/>
    		<form:errors cssClass="errors" id="_placement" path="placement"/>
   	</div>
   	<div id="task_personName">
       		<label for="_personName">Added by:</label>
       		<form:input cssStyle="width:300px" id="_personName" path="personName"/>
       		<br/>
       		<form:errors cssClass="errors" id="_personName" path="personName"/>
    </div>
	<div class="submit" id="deployment_submit">
		<input id="proceed" type="submit" value="Submit"/>
	</div>
	</form:form>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>