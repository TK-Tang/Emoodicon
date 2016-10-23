<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Edit an old product on this page</title>
	</head>
	<body>
		<h1>You can edit the product shown below</h1>
		<a href="/springmvc/projectList.htm">Project list view Page</a>
	
		<sf:form method="POST" modelAttribute="project">
			<fieldset>
				<table>
					<tr>
						<th>Project Title:</th>
						<td><sf:input path="name"/></td>
					</tr>
					<tr>
						<th><label for="project_description">Description:</label></th>
						<td><sf:input path="description"/></td>
					</tr>
					<tr>
						<th><label for="project_price">Price</label></th>
						<td><sf:input type="number" path="price"/></td>
					</tr>
					<tr>
						<th>Project Start Date:</th>
						<td><sf:input type="date" placeholder="" path="projectStartDate"/></td>
					</tr>
					<tr>
						<th>Project Deadline:</th>
						<td><sf:input type="date" placeholder="" path="projectDeadline"/></td>
					</tr>
					<tr>
						<th><button type="reset">Reset</button></th>
						<!-- This hidden field is required for Hibernate to recognize this Product -->
						<td><sf:hidden path="id"/>
						<td><input type="submit" value="Done"/></td>
					</tr>
				</table>			
			</fieldset>
		</sf:form>
	</body>
</html>