<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
	<c:if test="${not empty result}">
		<div id="task_project.name">
           	<label for="_project.name">Project:</label>
           	<div class="box" id="_project.name">${result.project.name}</div>
        </div>
        <br/>
		<div id="task_name">
			<label for="_name">Task:</label>
			<div class="box" id="_name">${result.name}</div>
		</div>
		<br/>
		<div id="task_description">
			<label for="_description">Description:</label>
			<div class="box" id="_description">${result.description}</div>
		</div>
		<br/>
		<div id="task_taskType">
    		<label for="_taskType">Type:</label>
    		<div class="box" id="_taskType">${result.taskType}</div>
      	</div>
    	<br/>
		<div id="task_originDate">
			<label for="_originDate">Origin date:</label>
			<div class="box" id="_originDate">${result.originDate}</div>
		</div>
		<br/>
		<div id="task_priority">
        	<label for="_priority">Priority:</label>
        	<div class="box" id="_priority">${result.priority}</div>
        </div>
		<br/>
		<div id="task_deadline">
			<label for="_deadline">Deadline:</label>
			<div class="box" id="_deadline">${result.deadline}</div>
		</div>
		<br/>
		<div id="task_status">
    		<label for="_status">Status:</label>
    		<div class="box" id="_status">${result.status}</div>
    	</div>
    	<br/>
    	<div id="task_placement">
        	<label for="_placement">Environment:</label>
        	<div class="box" id="_placement">${result.placement}</div>
        </div>
    	<br/>
	</c:if>
	<c:if test="${empty result}">No Task found with this id.</c:if>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
