<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

 <%-- Code adapted from http://www.journaldev.com/3531/spring-mvc-hibernate-mysql-integration-crud-example-tutorial --%>

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

	<c:url var="addAction" value="/upload"></c:url>

	<form:form modelAttribute="emojiFamilyImpl" action="${addAction}" enctype="multipart/form-data">
		<table>
			<c:if test="${!empty emojiFamilyImpl.name}">
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
				<td><form:label path="fileLowMood">
						<spring:message text="Low mood image (jpg file)" />
					</form:label></td>
				<td><form:input type="file" path="fileLowMood"/></td>
			</tr>
			<tr>
				<td><form:label path="fileMedMood">
						<spring:message text="Medium mood image (jpg file)" />
					</form:label></td>
				<td><form:input type="file" path="fileMedMood"/></td>
			</tr>
				<tr>
				<td><form:label path="fileHighMood">
						<spring:message text="High mood image (jpg file)" />
					</form:label></td>
				<td><form:input type="file" path="fileHighMood"/></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty emojiFamilyImpl.name}">
						<input type="submit" value="<spring:message text="Edit emoji theme"/>" />
					</c:if> <c:if test="${empty emojiFamilyImpl.name}">
						<input type="submit" value="<spring:message text="Add emoji theme"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>

<br>
<h3>Emoji Family List</h3>
<c:if test="${!empty listThemes}">
	<table class="tg">
	<tr>
		<th width="80">Emoji ID</th>
		<th width="120">Emoji Name</th>
		<th width="120">Default</th>
		<th width="120">Low</th>
		<th width="120">Med</th>
		<th width="120">High</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listThemes}" var="theme">
		<tr>
			<td>${theme.id}</td>
			<td>${theme.name}</td>
			<td>${theme.defaultEmoji}</td>
			<td>
				<img src="data:image/jpeg;charset=utf-8;base64,${theme.base64EncodedImageLow}"/>
			</td>
			<td>
				<img src="data:image/jpeg;charset=utf-8;base64,${theme.base64EncodedImageMed}"/>
			</td>
			<td>
				<img src="data:image/jpeg;charset=utf-8;base64,${theme.base64EncodedImageHigh}"/>
			</td>
			<td><a href="<c:url value='/emojiThemeUpdate/${theme.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/emojiThemeDelete/${theme.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>


</body>
</html>