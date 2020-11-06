<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
	<h2>New Communication</h2>
	<c:url value="/rest/communication" var="action"/>
	<form:form action="${action}" method="POST" modelAttribute="entity">
	<div id="communication_taskId">
       	<label for="_task.id">Task:</label>
       	<form:input cssStyle="width:300px" id="_task.id" path="task.id"/>
       	<br/>
       	<form:errors cssClass="errors" id="_task.id" path="task.id"/>
    </div>
    <div id="communication_sender">
    		<label for="_sender">Sender:</label>
    		<form:input cssStyle="width:300px" id="_sender" path="sender"/>
    		<br/>
    		<form:errors cssClass="errors" id="_sender" path="sender"/>
    	</div>
    <div id="communication_recipient">
    		<label for="_recipient">Recipient:</label>
    		<form:input cssStyle="width:300px" id="_recipient" path="recipient"/>
    		<br/>
    		<form:errors cssClass="errors" id="_recipient" path="recipient"/>
    	</div>
	<div id="communication_content">
		<label for="_content">Content:</label>
		<form:input cssStyle="width:300px" id="_content" path="content"/>
		<br/>
		<form:errors cssClass="errors" id="_content" path="content"/>
	</div>
	<div class="submit" id="communication_submit">
		<input id="proceed" type="submit" value="Save"/>
	</div>
	</form:form>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
