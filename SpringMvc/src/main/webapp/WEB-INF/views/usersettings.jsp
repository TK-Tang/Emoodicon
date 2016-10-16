<%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<%@ page session="false"%>
<html>
<head>
<title>Settings</title>
</head>
<body>
<body>
	<h2>User Settings</h2>
	<mvc:form modelAttribute="Users"  method = "post" action="${pageContext.request.contextPath}/usereditprofile" commandName = "user">
		<table>
			<tr>
				<td><mvc:label path="nameFirst">Name</mvc:label></td>
				<td><mvc:input path="nameFirst" cssErrorClass="formFieldError" /></td>
				<td><mvc:errors path="nameFirst" /></td>
			</tr>
			<tr>
				<td><mvc:label path="nameLast">Last Name</mvc:label></td>
				<td><mvc:input path="nameLast" cssErrorClass="formFieldError" /></td>
				<td><mvc:errors path="nameLast" /></td>
			</tr>
			<tr>
				<td><mvc:label path="password">Password</mvc:label></td>
				<td><mvc:password path="password" /></td>
			</tr>
			<tr>
				<td><mvc:label path="detail">Detail</mvc:label></td>
				<td><mvc:textarea path="detail" /></td>
			</tr>
			<tr>
				<td><mvc:label path="gender">Gender</mvc:label></td>
				<td><mvc:radiobuttons path="gender" items="${genders}" /></td>
			</tr>
			<tr>
				<td><mvc:label path="country">Country</mvc:label></td>
				<td><mvc:select path="country" items="${countries}" /></td>
			</tr>
			<tr>

				<td><mvc:label path="nonSmoking">Non Smoking</mvc:label></td>
				<td><mvc:checkbox path="nonSmoking" /></td>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath}/dashboard.jsp"><button>Cancel</button></a></td>
				<td colspan="2">
					<!-- This hidden field is required for Hibernate to recognize this User -->
				<td><mvc:hidden path="username" /> <input type="submit" value="Save" />
				</td>
			</tr>
		</table>
	</mvc:form>

</body>
</html>
