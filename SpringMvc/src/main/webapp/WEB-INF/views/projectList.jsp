<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
	<head>
		<title><fmt:message key="title" /></title>
	</head>
	<body>
		<h3>Products</h3>
		<c:forEach items="${model.projects}" var="prod">
				<c:out value="${prod.description}" />
				<br />
				<i>$<c:out value="${prod.price}" /></i>
			<a href="projects/edit/${prod.id }">edit</a>
			<a href="projects/delete/${prod.id }">delete</a>
			<br>
			<br>
		</c:forEach>
	</body>
</html>