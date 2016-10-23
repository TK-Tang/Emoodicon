<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<html>
<head>
<title>Emoji Themes</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>
	<h1>Add an emoji theme</h1>

	<c:url var="addAction" value="upload"></c:url>

	<form:form modelAttribute="emojiFamilyImpl" action="${addAction}" enctype="multipart/form-data">
		<table>
			<c:if test="${!empty name}">
				<tr>
					<td><form:label path="id">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="id" readonly="true" size="8"
							disabled="true" /> <form:hidden path="id" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="name">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="defaultEmoji">
						<spring:message text="Project default" />
					</form:label></td>
				<td><form:checkbox path="defaultEmoji" /></td>
			</tr>
			<tr>
				<td><form:label path="file">
						<spring:message text="Low mood image" />
					</form:label></td>
				<td><form:input type="file" path="file"/></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty emojiTheme.name}">
						<input type="submit" value="<spring:message text="Edit emoji theme"/>" />
					</c:if> <c:if test="${empty person.name}">
						<input type="submit" value="<spring:message text="Add emoji theme"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>

</body>
</html>