<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
	<c:if test="${not empty result}">
		<div id="task_nameOfProject">
           	<label for="_project.nameOfProject">Project:</label>
           	<div class="box" id="_project.nameOfProject">${result.project.nameOfProject}</div>
        </div>
        <br/>
		<div id="task_nameOfTask">
			<label for="_nameOfTask">Task name:</label>
			<div class="box" id="_nameOfTask">${result.nameOfTask}</div>
		</div>
		<br/>
		<div id="task_description">
			<label for="_description">Description:</label>
			<div class="box" id="_description">${result.description}</div>
		</div>
		<br/>
		<div id="task_typeOfTask">
    		<label for="_typeOfTask">Type:</label>
    		<div class="box" id="_typeOfTask">${result.typeOfTask}</div>
      	</div>
    	<br/>
		<div id="task_dateOfOrigin">
			<label for="_dateOfOrigin">Origin date:</label>
			<div class="box" id="_dateOfOrigin">${result.dateOfOrigin}</div>
		</div>
		<br/>
		<div id="task_taskPriority">
        	<label for="_taskPriority">Priority:</label>
        	<div class="box" id="_taskPriority">${result.taskPriority}</div>
        </div>
		<br/>
		<div id="task_deadline">
			<label for="_deadline">Deadline:</label>
			<div class="box" id="_deadline">${result.deadline}</div>
		</div>
		<br/>
		<div id="task_state">
    		<label for="_state">State:</label>
    		<div class="box" id="_state">${result.state}</div>
    	</div>
    	<br/>
	</c:if>
	<c:if test="${empty result}">No Task found with this id.</c:if>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
