<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
	<h2>New Deployment</h2>
	<c:url value="/rest/deployment" var="action"/>
	<form:form action="${action}" method="POST" modelAttribute="entity">
	<div id="deployment_label">
		<label for="_label">Label:</label>
		<form:input cssStyle="width:300px" id="_label" path="label"/>
		<br/>
		<form:errors cssClass="errors" id="_label" path="label"/>
	</div>
	<div id="deployment_environment">
    		<label for="_environment">Environment:</label>
    		<form:input cssStyle="width:300px" id="_environment" path="environment"/>
    		<br/>
    		<form:errors cssClass="errors" id="_environment" path="environment"/>
   	</div>
	<div class="submit" id="deployment_submit">
		<input id="proceed" type="submit" value="Save"/>
	</div>
	</form:form>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
