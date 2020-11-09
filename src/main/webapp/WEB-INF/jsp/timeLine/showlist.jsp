<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
<a href="<c:url value="/rest/timeLine/form" />">New TimeLine</a>
</div>
<div>
	<c:if test="${not empty result}">
	<table>
		<thead>
		<th>Id</th>
		<th>Date</th>
		<th>Label</th>
		<th>User</th>
		<th>Task</th>
		<th/>
		<th/>
		</thead>
		<c:forEach items="${result}" var="each" >
			<tr>
				<td>
					<a href="<c:url value="/rest/timeLine/${each.id}" />">${each.id}</a>
				</td>
				<td>
					${each.date}
				</td>
				<td>
					${each.label}
				</td>
				<td>
                	${each.useer.name}
                </td>
                <td>
                   	${each.task.name}
                </td>
				<td>
					<a href="<c:url value="/rest/timeLine/${each.id}" />">Show</a>
				</td>
				<td>
					<c:url value="/rest/timeLine/${each.id}" var="action"/>
					<form:form action="${action}" method="DELETE">
						<input id="delete" type="submit" value="Delete"/>
					</form:form>
				</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
	<c:if test="${empty result}"><p>There are no TimeLines yet.</p></c:if>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>

