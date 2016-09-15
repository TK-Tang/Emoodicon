<%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ page session="false" %>
<html>
<head>
	<title>User Form</title>
</head>
<body>

<body>
<h2>User Registration Form</h2>
<mvc:form modelAttribute="user" action="result.mvc">
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
            <td><mvc:label path="birthDate">Birth Date</mvc:label></td>
            <td><mvc:input path="birthDate" /></td>
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
            <td colspan="2">
                <input type="submit" value="Submit" />
            </td>
        </tr>
    </table>
</mvc:form>

</body>
</html>
