<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- THESE TAGLIBS ARE NEEDED FOR TAGS IN JAVA STANDARD TEMPLATE LIBRARY JSTL AND SQL QUERIES -->
<!-- JDBC JAR NEED IN TOMCAT7'S LIB DIRECTORY OR IT CANNOT FIND JDBC DRIVER -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Offers Homepage</title>
</head>
<body>

	<a href="${pageContext.request.contextPath}/Offers"> Show current offers</a>
	<a href="${pageContext.request.contextPath}/CreateOffer"> Add a new Offer</a>
	<p />
	<!--
		<sql:query var="rs" dataSource="jdbc/mydb">
			SELECT IDOffers, Name, Email, Description FROM Offers
		</sql:query>
	
		<c:forEach var="row" items="${rs.rows}">
	    	ID: ${row.IDOffers}<br />
	    	Name: ${row.Name}<br />
	    	Email: ${row.Email}<br />
	    	Description ${row.Description}<br />
		</c:forEach>
	-->
	<!--  EMBEDDING JAVA IS BAD -> THIS IS AN EXAMPLE. Session and Request are implicit objects part of the %= -->
	
	Session:
	<%=session.getAttribute("name")%>
	<p />
	Request:
	<%=request.getAttribute("name")%>
	<p />
	Request using Expression Language : ${name}
	<p />

	<c:out value="${name}"></c:out>
	<p />

	<c:forEach var="row" items="${offers}">
		
		ID: ${row.ID}<br />
    	Name: ${row.name}<br />
    	Email: ${row.email}<br />
    	Description ${row.description}<br />
    	
	</c:forEach>

</body>
</html>