<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
<h2>Tasks</h2>
<a href="<c:url value="/rest/task/form" />">New Task</a>
<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
<a href="<c:url value="/rest/task/changestatus/form" />">Change Task Status</a>

</div>
<div>
	<c:if test="${not empty result}">
	<table>
		<thead>
		<th>Id</th>
		<th>Project ID</th>
		<th>Task</th>
		<th>Description</th>
		<th>Type</th>
		<th>Origin Date</th>
		<th>Priority</th>
		<th>Deadline</th>
		<th>Status</th>
		<th>Environment</th>
		<th>Created by</th>
		<th/>
		<th/>
		</thead>
		<c:forEach items="${result}" var="each" >
			<tr>
				<td>
					<a href="<c:url value="/rest/task/${each.id}" />">${each.id}</a>
				</td>
				<td>
                    <a href="<c:url value="/rest/project/${each.project.id}" />">${each.project.id}</a>
                </td>
				<td>
					${each.name}
				</td>
				<td>
					${each.description}
				</td>
				<td>
                	${each.taskType}
                </td>
				<td>
					${each.originDate}
				</td>
				<td>
                	${each.priority}
                </td>
				<td>
					${each.deadline}
				</td>
				<td>
                	${each.status}
                </td>
                <td>
                   	${each.placement}
                </td>
                <td>
                	${each.person.name}
                </td>
				<td>
					<c:url value="/rest/task/${each.id}" var="action"/>
					<form:form action="${action}" method="DELETE">
						<input id="delete" type="submit" value="Delete"/>
					</form:form>
				</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
	<c:if test="${empty result}"><p>There are no Tasks yet.</p></c:if>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>

