<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
	<h2>New Task</h2>
	<c:url value="/rest/task" var="action"/>
	<form:form action="${action}" method="POST" modelAttribute="entity">
	<div id="task_projectId">
       	<label for="_projectId">Project ID:</label>
       	<form:input cssStyle="width:300px" id="_projectId" path="projectId"/>
       	<br/>
       	<form:errors cssClass="errors" id="_projectId" path="projectId"/>
    </div>
	<div id="task_name">
		<label for="_name">Task:</label>
		<form:input cssStyle="width:300px" id="_name" path="name"/>
		<br/>
		<form:errors cssClass="errors" id="_name" path="name"/>
	</div>
	<div id="task_description">
		<label for="_description">Description:</label>
		<form:input cssStyle="width:300px" id="_description" path="description"/>
		<br/>
		<form:errors cssClass="errors" id="_description" path="description"/>
	</div>
	<div id="task_taskType">
    	<label for="_taskType">Type:</label>
    	<form:input cssStyle="width:300px" id="_taskType" path="taskType"/>
    	<br/>
    <form:errors cssClass="errors" id="_taskType" path="taskType"/>
    </div>
    <div id="task_priority">
       	<label for="_priority">Priority:</label>
       	<form:input cssStyle="width:300px" id="_priority" path="priority"/>
       	<br/>
        <form:errors cssClass="errors" id="_priority" path="priority"/>
    </div>
	<div id="task_deadline">
		<label for="_deadline">Deadline:</label>
		<form:input cssStyle="width:300px" id="_deadline" path="deadline"/>
		<br/>
		<form:errors cssClass="errors" id="_deadline" path="deadline"/>
	</div>
	<div id="task_status">
       	<label for="_status">Status:</label>
       	<form:input cssStyle="width:300px" id="_status" path="status"/>
       	<br/>
        <form:errors cssClass="errors" id="_status" path="status"/>
    </div>
    <div id="task_placement">
       	<label for="_placement">Environment:</label>
       	<form:input cssStyle="width:300px" id="_placement" path="placement"/>
       	<br/>
        <form:errors cssClass="errors" id="_placement" path="placement"/>
    </div>
	<div class="submit" id="task_submit">
		<input id="proceed" type="submit" value="Save"/>
	</div>
	</form:form>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
