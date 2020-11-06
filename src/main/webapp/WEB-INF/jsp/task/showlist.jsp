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
		<th>Task name</th>
		<th>Description</th>
		<th>Type</th>
		<th>Origin date</th>
		<th>Priority</th>
		<th>Deadline</th>
		<th>State</th>
		<th/>
		<th/>
		</thead>
		<c:forEach items="${result}" var="each" >
			<tr>
				<td>
					<a href="<c:url value="/rest/task/${each.id}" />">${each.id}</a>
				</td>
				<td>
                    ${each.project.nameOfProject}
                </td>
				<td>
					${each.nameOfTask}
				</td>
				<td>
					${each.description}
				</td>
				<td>
                	${each.typeOfTask}
                </td>
				<td>
					${each.dateOfOrigin}
				</td>
				<td>
                	${each.taskPriority}
                </td>
				<td>
					${each.deadline}
				</td>
				<td>
                	${each.state}
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

