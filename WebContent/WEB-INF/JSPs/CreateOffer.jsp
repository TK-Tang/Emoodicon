<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/main.css"
	type="text/css" />
	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Offer</title>
</head>
<body>
	<sf:form method="post"
		action="${pageContext.request.contextPath}/doCreate"
		commandName="offer">
		<table class="formtable">
			<tr>
				<td class="label">Name:</td>
				<td><sf:input path="name" name="name" type="text"
						class="control" /> <br /> <sf:errors path="name"
						cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Email:</td>
				<td><sf:input path="email" name="email" type="text"
						class="control" /> <br /> <sf:errors path="email"
						cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Offer:</td>
				<td><sf:textarea path="description" name="description"
						rows="10" cols="50" class="control"></sf:textarea><br />
				<sf:errors path="description" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input value="Create advert" type="submit" class="control" /></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>