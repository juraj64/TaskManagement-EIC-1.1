<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
	<h2>No user with this name in DB. Try again!</h2>
	<c:url value="/rest/communication" var="action"/>
	<form:form action="${action}" method="POST" modelAttribute="entity">
	<div id="communication_task">
       	<label for="_task.name">Task:</label>
       	<form:input cssStyle="width:300px" id="_task.name" path="task.name"/>
       	<br/>
       	<form:errors cssClass="errors" id="_task.name" path="task.name"/>
    </div>
    <div id="communication_senderName">
    		<label for="_senderName">From:</label>
    		<form:input cssStyle="width:300px" id="_senderName" path="senderName"/>
    		<br/>
    		<form:errors cssClass="errors" id="_senderName" path="senderName"/>
    	</div>
    <div id="communication_recipientName">
    		<label for="_recipientName">To:</label>
    		<form:input cssStyle="width:300px" id="_recipientName" path="recipientName"/>
    		<br/>
    		<form:errors cssClass="errors" id="_recipientName" path="recipientName"/>
    	</div>
	<div id="communication_content">
		<label for="_content">Message:</label>
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