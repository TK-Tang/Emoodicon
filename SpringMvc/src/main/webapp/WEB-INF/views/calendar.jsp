<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Emoodicon - Calendar</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="<c:url value="/resources/css/styles.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/calendarcss.css" />"
	rel="stylesheet">

<!--Icons-->
<script src="<c:url value="/resources/js/lumino.glyphs.js" />"></script>

</head>

<body class="user-settings">
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/springmvc/">E<span>MOOD</span>ICON
				</a>
				<ul class="user-menu">
					<li class="dropdown pull-right"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"><svg
								class="glyph stroked male-user">
								<use xlink:href="#stroked-male-user"></use></svg> ${username} <span
							class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a
								href="${pageContext.request.contextPath}/userprofile/"><svg
										class="glyph stroked male-user">
										<use xlink:href="#stroked-male-user"></use></svg> Profile</a></li>
							<li><a
								href="${pageContext.request.contextPath}/usersettings/"><svg
										class="glyph stroked gear">
										<use xlink:href="#stroked-gear"></use></svg> Settings</a></li>
							<li><a href="${pageContext.request.contextPath}/logout/"><svg
										class="glyph stroked cancel">
										<use xlink:href="#stroked-cancel"></use></svg> Logout</a></li>
						</ul></li>
				</ul>
			</div>

		</div>
		<!-- /.container-fluid -->
	</nav>

	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">

		<form role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
		</form>
		<ul class="nav menu">
			<li class="active"><a href="${pageContext.request.contextPath}/dashboard"><svg
						class="glyph stroked dashboard-dial">
						<use xlink:href="#stroked-dashboard-dial"></use></svg> Dashboard</a></li>
			<!-- <li><a href="widgets.html"><svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"></use></svg> Widgets</a></li>
            <li><a href="charts.html"><svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg> Charts</a></li>
            <li><a href="tables.html"><svg class="glyph stroked table"><use xlink:href="#stroked-table"></use></svg> Tables</a></li>
            <li><a href="forms.html"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg> Forms</a></li>
            <li><a href="panels.html"><svg class="glyph stroked app-window"><use xlink:href="#stroked-app-window"></use></svg> Alerts &amp; Panels</a></li>
            <li><a href="icons.html"><svg class="glyph stroked star"><use xlink:href="#stroked-star"></use></svg> Icons</a></li>
            -->
			<li><a href="${pageContext.request.contextPath}/projects/add"><svg
						class="glyph stroked plus sign">
						<use xlink:href="#stroked-plus-sign" /></svg> Create Project</a></li>
			<li class="parent"><a data-toggle="collapse" href="#sub-item-1">
					<span><svg class="glyph stroked star">
							<use xlink:href="#stroked-star"></use></svg> Current Projects </span>
			</a>
				<ul class="children collapse" id="sub-item-1">
					<c:forEach items="${projects}" var="proj" varStatus="projCounter">
						<%-- <c:choose>
                            <c:when test="${projCounter.count > 1}"> --%>
						<li><a href="#"> <svg class="glyph stroked line-graph">
									<use xlink:href="#stroked-line-graph"></use></svg> <c:out
									value="${proj.description}" />
						</a></li>
						<%-- </c:when>
                            <c:otherwise>
                                <li class="active-project">
                                    <a href="#">
                                        <svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg> 
                                        <c:out value="${proj.description}" />
                                    </a>
                                </li>
                            </c:otherwise>
                        </c:choose> --%>

					</c:forEach>

					<!-- <li class="active-project">
                        <a class="" href="#">
                            <svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg> 
                            Project Manhattan
                        </a>
                    </li>-->
				</ul></li>
			<li class="parent"><a data-toggle="collapse" href="#sub-item-2">
					<span><svg class="glyph stroked flag">
							<use xlink:href="#stroked-flag" /></svg> Past Projects </span>
			</a>
				<ul class="children collapse" id="sub-item-2">
					<li><a class="" href="#"> <svg
								class="glyph stroked line-graph">
								<use xlink:href="#stroked-line-graph"></use></svg> Project Mars
					</a></li>
					<li><a class="" href="#"> <svg
								class="glyph stroked line-graph">
								<use xlink:href="#stroked-line-graph"></use></svg> Project Jupiter
					</a></li>
				</ul></li>
			<li role="presentation" class="divider"></li>
			<!-- <li><a href="login.html"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Login Page</a></li> -->
			<li><a href="#"> <span> <svg
							class="glyph stroked gear">
							<use xlink:href="#stroked-gear" /></svg> Settings
				</span>
			</a></li>
		</ul>

	</div>
	<!--/.sidebar-->

	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><svg class="glyph stroked home">
							<use xlink:href="#stroked-home"></use></svg></a></li>
				<li class="active">Dashboard</li>
			</ol>
		</div>
		<!--/.row-->

		<div class="row">
			<div class="col-sm-12">
				<h1 class="page-header"></h1>
				<%-- <p>Project Manager: 
                    <span class="project-manager">Ken Nichols</span> 
                </p>
                <span class="project-settings">
                    <a href="projects/edit/${projects[0].id }">
                        <svg class="glyph stroked gear"><use xlink:href="#stroked-gear"></use></svg>
                    </a>
                </span> --%>
			</div>
		</div>
		<!--/.row-->

		<!-- body -->
		
		<c:forEach items="${dateMonths}" var="month">
			<div class="month">
				<ul>
					<li class="prev">&#10094;</li>
					<li class="next">&#10095;</li>
					<li style = "text-align:center;">
						<span style="font-size: 18px;">${month.month}</span>
						<br>

						<span style="font-size: 18px;">${maxYear}</span>
					</li>
				</ul>
			</div>
	
			<ul class="weekdays">
				<li>Mo</li>
				<li>Tu</li>
				<li>We</li>
				<li>Th</li>
				<li>Fr</li>
				<li>Sa</li>
				<li>Su</li>
			</ul>
			
			<c:set var="dayCount" scope="page" value="0"/>
			<c:set var="set" scope="page" value="0"/>
			<ul class="days">
				<c:forEach begin="0" end="${month.days - 1}">
					<c:set var="dayCount" value="${dayCount + 1}"/>
						<c:forEach items="${dateLog}" var="currentDate">
						
						<!--  
							${currentDate.year} ${maxYear} <br/>
							${currentDate.month} ${month.monthNumber} <br/>
							${currentDate.day} ${dayCount} <br/>
							-->
							<c:choose>
								<c:when test="${currentDate.year == maxYear && currentDate.month == month.monthNumber && currentDate.day == dayCount}">

													<c:choose>
														<c:when test="${currentDate.mood == 0}">
															<li><span class="negative"><c:out value="${dayCount}"/></span></li>
														</c:when>
														<c:when test="${currentDate.mood == 1}">
															<li><span class="neutral"><c:out value="${dayCount}"/></span></li>
														</c:when>
														<c:when test="${currentDate.mood == 2}">
															<li><span class="positive"><c:out value="${dayCount}"/></span></li>
														</c:when>
													</c:choose>
													<c:set var="set" scope="page" value="1"/>
								</c:when>
							</c:choose>
							
						</c:forEach>
					<c:choose>
						<c:when test="${set == 0}">
							<li><c:out value="${dayCount}"/>
							</li>
						</c:when>
					</c:choose>
					<c:set var="set" value="0"/>
				</c:forEach>
			</ul>
		</c:forEach>

		<div class="emote">

			<p class="white">How was your current day?</p>

			<div class="emotecontent">

				<sf:form method="post"
					action="${pageContext.request.contextPath}/setemote"
					commandName="calendarobject">
					<table >
						<tr>
							<td>
								<sf:input path="currentDate" type="date" />

								<sf:select  path="mood"  type="text" >
									<sf:option value="0">Negative</sf:option>
									<sf:option value="1">Neutral</sf:option>
									<sf:option value="2">Positive</sf:option>
								</sf:select>
								<br/>
							</td>
						<tr>
							<td> 
								<br/>
								<div>

									<input value="Submit" type="submit"  />
									<input class = "hitit" type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								</div>
							</td>
						</tr>
					</table>

				</sf:form>
					<br/>
					<c:if test = "${error != null}">
						<p class="white">[!] Your date cannot be null [!]</p>
					</c:if>
			</div>


		</div>

	</div>
	<!--/.main-->

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/1.0.2/Chart.js"></script>
	<script src="<c:url value="/resources/js/chart-data.js"/>"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/easy-pie-chart/2.1.6/easypiechart.min.js"></script>
	<script src="<c:url value="/resources/js/easypiechart-data.js" />"></script>

</body>

</html>
