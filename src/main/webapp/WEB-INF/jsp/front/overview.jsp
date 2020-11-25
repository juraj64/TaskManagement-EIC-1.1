<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
<p>
<p><font size="5" color="saddlebrown">EIC-Taskmanager</font></p>
</p>
<ul>
<li><a href="<c:url value="/rest/project" />">Projects</a></li>
<li><a href="<c:url value="/rest/endUser" />">Users</a></li>
<br/>
<li><a href="<c:url value="/rest/task" />">Tasks</a></li>
<li><a href="<c:url value="/rest/timeLine" />">TimeLines and Deployments</a></li>
<li><a href="<c:url value="/rest/communication" />">Communications</a></li>
</ul>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>

