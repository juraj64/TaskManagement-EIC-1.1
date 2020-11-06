<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
	<c:if test="${not empty result}">
		<div id="communication_nameOfTask">
           	<label for="_task.nameOfTask">Task:</label>
           	<div class="box" id="_task.nameOfTask">${result.task.nameOfTask}</div>
        </div>
        <br/>
        <div id="communication_sender">
        	<label for="_sender">Sender:</label>
        	<div class="box" id="_sender">${result.sender}</div>
        </div>
        <br/>
        <div id="communication_recipient">
        	<label for="_recipient">Recipient:</label>
        	<div class="box" id="_recipient">${result.recipient}</div>
        </div>
        <br/>
		<div id="communication_content">
			<label for="_content">Content:</label>
			<div class="box" id="_content">${result.content}</div>
		</div>
		<br/>
		<div id="communication_dateOfCommunication">
			<label for="_dateOfCommunication">Date:</label>
			<div class="box" id="_dateOfCommunication">${result.dateOfCommunication}</div>
		</div>
		<br/>
	</c:if>
	<c:if test="${empty result}">No Communication found with this id.</c:if>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
