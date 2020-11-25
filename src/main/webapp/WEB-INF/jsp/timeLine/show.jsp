<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
	<c:if test="${not empty result}">
		<div id="timeLine_task.name">
           	<label for="_task.name">Task:</label>
           	<div class="box" id="_task.name">${result.task.name}</div>
        </div>
        <br/>
        <div id="timeLine_label">
    		<label for="_label">Label:</label>
    		<div class="box" id="_label">${result.label}</div>
    	</div>
    	<br/>
		<div id="timeLine_date">
			<label for="_date">Date:</label>
			<div class="box" id="_date">${result.date}</div>
		</div>
		<br/>
		<div id="timeLine_person.name">
           	<label for="_person.name">Created by:</label>
           	<div class="box" id="_person.name">${result.person.name}</div>
        </div>
		<br/>
	</c:if>
	<c:if test="${empty result}">No TimeLine found with this id.</c:if>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
