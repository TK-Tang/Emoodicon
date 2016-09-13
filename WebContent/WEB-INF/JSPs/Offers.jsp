<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Offers</title>
</head>
<body>

	<!--  $name and $offers must match model attributes specified in controller -->
	<c:out value="${name}"></c:out>

	<table>
		<tr>
			<td>Name</td>
			<td>Email</td>
			<td>Description</td>
		</tr>
		<c:forEach var="offer" items="${offers}">
			<tr>
				<td><c:out value="${offer.name}"></c:out></td>
				<td><c:out value="${offer.email}"></c:out></td>
				<td><c:out value="${offer.description}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>