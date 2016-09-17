<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Login Page</title>

<link
	href="${pageContext.request.contextPath}/StaticResources/css/main.css"
	rel="stylesheet" type="text/css" />

</head>
<body onload='document.f.username.focus();'>
	<h3>Login with Username and Password</h3>

	<c:if test = "${param.error != null}">
	<p class="error">[!] Login failed. Check your username and password. [!]</p>
	</c:if>

	<form name='f'
		action="${pageContext.request.contextPath}/j_spring_security_check"
		method='POST'>
		<table class="formtable ">
			<tr>
				<td>User:</td>
				<td><input type='text' name='j_username' value=''></td> <!--  There is actually an underscore between j and username, j and password etc -->
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='j_password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login" /></td>
				<td><input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /></td>
			</tr>
		</table>
	</form>
	
	<p><a href= "<c:url value = "/NewAccount"/>"> Create new account</a></p>
	<!--  Some fancy way to add a new URL over pageContext.request.contextPath -->
</body>
</html>