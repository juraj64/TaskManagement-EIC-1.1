<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
	<h2>New Task</h2>
	<c:url value="/rest/task" var="action"/>
	<form:form action="${action}" method="POST" modelAttribute="entity">
	<div id="task_projectId">
       	<label for="_project.id">Project:</label>
       	<form:input cssStyle="width:300px" id="_project.id" path="project.id"/>
       	<br/>
       	<form:errors cssClass="errors" id="_project.id" path="project.id"/>
    </div>
	<div id="task_nameOfTask">
		<label for="_nameOfTask">Task name:</label>
		<form:input cssStyle="width:300px" id="_nameOfTask" path="nameOfTask"/>
		<br/>
		<form:errors cssClass="errors" id="_nameOfTask" path="nameOfTask"/>
	</div>
	<div id="task_description">
		<label for="_description">Description:</label>
		<form:input cssStyle="width:300px" id="_description" path="description"/>
		<br/>
		<form:errors cssClass="errors" id="_description" path="description"/>
	</div>
	<div id="task_typeOfTask">
    	<label for="_typeOfTask">Type:</label>
    	<form:input cssStyle="width:300px" id="_typeOfTask" path="typeOfTask"/>
    	<br/>
    <form:errors cssClass="errors" id="_typeOfTask" path="typeOfTask"/>
    </div>
    <div id="task_taskPriority">
       	<label for="_taskPriority">Priority:</label>
       	<form:input cssStyle="width:300px" id="_taskPriority" path="taskPriority"/>
       	<br/>
        <form:errors cssClass="errors" id="_taskPriority" path="taskPriority"/>
    </div>
	<div id="task_deadline">
		<label for="_deadline">Deadline:</label>
		<form:input cssStyle="width:300px" id="_deadline" path="deadline"/>
		<br/>
		<form:errors cssClass="errors" id="_deadline" path="deadline"/>
	</div>
	<div id="task_state">
       	<label for="_state">State:</label>
       	<form:input cssStyle="width:300px" id="_state" path="state"/>
       	<br/>
        <form:errors cssClass="errors" id="_state" path="state"/>
    </div>
	<div class="submit" id="task_submit">
		<input id="proceed" type="submit" value="Save"/>
	</div>
	</form:form>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
