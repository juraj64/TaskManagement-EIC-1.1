<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
<a href="<c:url value="/rest/communication" />">Show All</a>
</div>
<div>
	<c:if test="${not empty result}">
	<table>
		<thead>
		<th>Id</th>
		<th>Task</th>
		<th>From</th>
        <th>To</th>
        <th>Message</th>
		<th>Date</th>
		<th/>
		<th/>
		</thead>
		<c:forEach items="${result}" var="each" >
			<tr>
				<td>
					<a href="<c:url value="/rest/communication/${each.id}" />">${each.id}</a>
				</td>
				<td>
                   <a href="<c:url value="/rest/task/${each.task.id}" />">${each.task.name}</a>
                </td>
				<td>
					${each.sender.name}
				</td>
				<td>
                	${each.recipient.name}
                </td>
                <td>
                    ${each.content}
                </td>
				<td>
					${each.date}
				</td>
				<td>
					<c:url value="/rest/communication/${each.id}" var="action"/>
					<form:form action="${action}" method="DELETE">
						<input id="delete" type="submit" value="Delete"/>
					</form:form>
				</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
	<c:if test="${empty result}"><p>There are no Communications yet.</p></c:if>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>