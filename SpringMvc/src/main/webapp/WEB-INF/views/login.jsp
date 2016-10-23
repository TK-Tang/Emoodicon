<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Login Page</title>

<link
	href="${weppappRoot}/resources/css/theme.css"
	rel="stylesheet" type="text/css" />

</head>
<body onload='document.f.username.focus();'>
	<h3>Login with Username and Password</h3>

	<c:if test = "${param.error != null}">
	<p class="error">[!] Login failed. Check your username and password. [!]</p>
	</c:if>
	
	<c:if test = "${param.hasCreated != null}">
	<p class="error"> USER CREATED</p>
	</c:if>

	<form name='login'
		action="<c:url value='j_spring_security_check' />"
		method='POST'>
		<table class="formtable ">
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="submit" /></td>
				<td><input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /></td>
			</tr>
		</table>
	</form>
	
	<p><a href= "<c:url value = "/newaccount"/>"> Create new account</a></p>
	<!--  Some fancy way to add a new URL over pageContext.request.contextPath -->
</body>
</html>