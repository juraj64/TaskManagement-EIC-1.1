<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
<h2>TimeLines</h2>
</div>
<div>
	<c:if test="${not empty result}">
	<table>
		<thead>
		<th>Id</th>
		<th><a href="<c:url value="/rest/timeLine/order/bytask" />">Task</th>
		<th>Label</th>
		<th><a href="<c:url value="/rest/timeLine" />">Date</th>
		<th>Created by</th>
		<th/>
		<th/>
		</thead>
		<c:forEach items="${result}" var="each" >
			<tr>
				<td>
					<a href="<c:url value="/rest/timeLine/${each.id}" />">${each.id}</a>
				</td>
				<td>
                   	<a href="<c:url value="/rest/timeLine/task/ascending/${each.task.id}" />">${each.task.name}</a>
                </td>
                <td>
            		${each.label}
                </td>
				<td>
					${each.date}
				</td>
				<td>
                	${each.person.name}
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