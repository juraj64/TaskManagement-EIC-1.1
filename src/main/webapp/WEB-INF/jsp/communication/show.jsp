<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
	<c:if test="${not empty result}">
		<div id="communication_task.name">
           	<label for="_task.name">Task:</label>
           	<div class="box" id="_task.name">${result.task.name}</div>
        </div>
        <br/>
        <div id="communication_sender.name">
        	<label for="_sender.name">Sender:</label>
        	<div class="box" id="_sender.name">${result.sender.name}</div>
        </div>
        <br/>
        <div id="communication_recipient.name">
        	<label for="_recipient.name">Recipient:</label>
        	<div class="box" id="_recipient.name">${result.recipient.name}</div>
        </div>
        <br/>
		<div id="communication_content">
			<label for="_content">Content:</label>
			<div class="box" id="_content">${result.content}</div>
		</div>
		<br/>
		<div id="communication_date">
			<label for="_date">Date:</label>
			<div class="box" id="_date">${result.date}</div>
		</div>
		<br/>
	</c:if>
	<c:if test="${empty result}">No Communication found with this id.</c:if>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
