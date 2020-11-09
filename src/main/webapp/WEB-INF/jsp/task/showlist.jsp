<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
<a href="<c:url value="/rest/task/form" />">New Task</a>
</div>
<div>
	<c:if test="${not empty result}">
	<table>
		<thead>
		<th>Id</th>
		<th>Project</th>
		<th>Task</th>
		<th>Description</th>
		<th>Type</th>
		<th>Origin date</th>
		<th>Priority</th>
		<th>Deadline</th>
		<th>Status</th>
		<th/>
		<th/>
		</thead>
		<c:forEach items="${result}" var="each" >
			<tr>
				<td>
					<a href="<c:url value="/rest/task/${each.id}" />">${each.id}</a>
				</td>
				<td>
                    ${each.project.name}
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
					<a href="<c:url value="/rest/task/${each.id}" />">Show</a>
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

