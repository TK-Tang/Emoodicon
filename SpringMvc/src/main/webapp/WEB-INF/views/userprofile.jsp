<%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false" %>
<html>
<head>
	<title>User Profile</title>
</head>
<body>

<body>
<h2>User Registration Result</h2>
<table>
<tr>
    <td>Username</td>
        <td><c:out value="${model.users.username}" /></td>
    </tr>
    <tr>
        <td>Name</td>
        <td>${model.users.nameFirst}</td>
    </tr>
    <tr>
        <td>Last name</td>
        <td>${model.users.nameLast}</td>
    </tr>
    <tr>
        <td>Password</td>
        <td>${model.users.password}</td>
    </tr>
    <tr>
        <td>Detail</td>
        <td>${model.users.detail}</td>
    </tr>
    <tr>
        <td>Gender</td>
        <td>${model.users.gender}</td>
    </tr>
    <tr>
        <td>Country</td>
        <td>${model.users.country}</td>
    </tr>
    <tr>
        <td>Non-Smoking</td>
        <td>${model.users.nonSmoking}</td>
    </tr>
</table>
</body>
</html>
