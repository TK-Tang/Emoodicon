<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
	<head>
		<title><fmt:message key="title" /></title>
	</head>
	<body>
		<a href="/springmvc/projects/add"> Project add</a>
		<h3>Products</h3>
		<c:forEach items="${model.projects}" var="prod">
			<c:out value="${prod.name}" />
			<br />
			<c:out value="${prod.description}" />
			<br />
			<c:out value="${prod.projectStartDate}" />
			<br />
			<c:out value="${prod.projectDeadline}" />
			<br />
			<i>$<c:out value="${prod.price}" /></i>
			<a href="projects/edit/${prod.id }">edit</a>
			<a href="projects/delete/${prod.id }">delete</a>
			<br>
			<br>
		</c:forEach>
	</body>
</html>