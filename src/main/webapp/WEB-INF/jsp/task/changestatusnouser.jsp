<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
	<h2>No user with this name in DB. Try again!</h2>
	<p>&nbsp; Correct sequence: Created --> Accepted --> Resolved or Returned</p>
	<c:url value="/rest/task/changestatus" var="action"/>
	<form:form action="${action}" method="POST" modelAttribute="entity">
	<div id="task_name">
    		<label for="_name">Task Name:</label>
    		<form:input cssStyle="width:300px" id="_name" path="name"/>
    		<br/>
    		<form:errors cssClass="errors" id="_name" path="name"/>
    </div>
    <div id="task_status">
           	<label for="_status">New Status:</label>
           	<form:input cssStyle="width:300px" id="_status" path="status"/>
           	<br/>
            <form:errors cssClass="errors" id="_status" path="status"/>
    </div>
    <div id="task_personName">
    		<label for="_personName">Changed by:</label>
    		<form:input cssStyle="width:300px" id="_personName" path="personName"/>
    		<br/>
    		<form:errors cssClass="errors" id="_personName" path="personName"/>
    </div>
	<div class="submit" id="task_submit">
    		<input id="proceed" type="submit" value="Submit"/>
    </div>
	</form:form>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>