<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add a new product on this page</title>
	</head>
	<body>
		<h1>Hi, you can add a new project on this page</h1>
		<form action="add" method="post">
			Name: <input type="text" name="name"/>
			Description: <input type="text" name="description"/>
			Price: <input type="number" name="price"/>
			Project Start Date: <input type="date" name="projectStartDate"/>
			Project Deadline: <input type="date" name="projectDeadline"/>
			<input type="submit" value="Add"/>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
	</body>
</html>