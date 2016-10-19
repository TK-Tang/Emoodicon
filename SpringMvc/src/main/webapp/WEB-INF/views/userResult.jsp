<%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ page session="false" %>
<html>
<head>
	<title>User Form Result</title>
</head>
<body>

<body>
<h2>User Registration Result</h2>
<table>
    <tr>
        <td>Name</td>
        <td>${u.nameFirst}</td>
    </tr>
    <tr>
        <td>Last name</td>
        <td>${u.nameLast}</td>
    </tr>
    <tr>
        <td>Password</td>
        <td>${u.password}</td>
    </tr>
    <tr>
        <td>Detail</td>
        <td>${u.detail}</td>
    </tr>
    <tr>
        <td>Birth Date</td>
        <td>${u.birthDate}</td>
    </tr>
    <tr>
        <td>Gender</td>
        <td>${u.gender}</td>
    </tr>
    <tr>
        <td>Country</td>
        <td>${u.country}</td>
    </tr>
    <tr>
        <td>Non-Smoking</td>
        <td>${u.nonSmoking}</td>
    </tr>
</table>
</body>
</html>
