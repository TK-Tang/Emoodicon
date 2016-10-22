<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Emoodicon - Page Title</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker3.min.css">
<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">

<!--Icons-->
<script src="<c:url value="/resources/js/lumino.glyphs.js" />"></script>

</head>

<body>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/springmvc/">E<span>MOOD</span>ICON</a>
                <ul class="user-menu">
                    <li class="dropdown pull-right">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> ${username} <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="${pageContext.request.contextPath}/userprofile/"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Profile</a></li>
                            <li><a href="${pageContext.request.contextPath}/usersettings/"><svg class="glyph stroked gear"><use xlink:href="#stroked-gear"></use></svg> Settings</a></li>
                            <li><a href="${pageContext.request.contextPath}/logout/"><svg class="glyph stroked cancel"><use xlink:href="#stroked-cancel"></use></svg> Logout</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
                            
        </div><!-- /.container-fluid -->
    </nav>
        
    <div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
    	
        <form role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search">
            </div>
        </form>
        <ul class="nav menu">
            <li class="active"><a href="index.html"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-dashboard-dial"></use></svg> Dashboard</a></li>
            <!-- <li><a href="widgets.html"><svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"></use></svg> Widgets</a></li>
            <li><a href="charts.html"><svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg> Charts</a></li>
            <li><a href="tables.html"><svg class="glyph stroked table"><use xlink:href="#stroked-table"></use></svg> Tables</a></li>
            <li><a href="forms.html"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg> Forms</a></li>
            <li><a href="panels.html"><svg class="glyph stroked app-window"><use xlink:href="#stroked-app-window"></use></svg> Alerts &amp; Panels</a></li>
            <li><a href="icons.html"><svg class="glyph stroked star"><use xlink:href="#stroked-star"></use></svg> Icons</a></li>
            -->
            <li><a href="${pageContext.request.contextPath}/projects/add"><svg class="glyph stroked plus sign"><use xlink:href="#stroked-plus-sign"/></svg> Create Project</a></li>
            <li class="parent">
                <a data-toggle="collapse" href="#sub-item-1">
                    <span><svg class="glyph stroked star"><use xlink:href="#stroked-star"></use></svg> Current Projects </span>
                </a>
                <ul class="children collapse" id="sub-item-1">
                	<c:forEach items="${projects}" var="proj" varStatus="projCounter">
                		<%-- <c:choose>
	                		<c:when test="${projCounter.count > 1}"> --%>
	                			<li>
			                        <a href="#">
			                            <svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg> 
			                            <c:out value="${proj.description}" />
			                        </a>
			                    </li>
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
                </ul>
            </li>
            <li class="parent">
                <a data-toggle="collapse" href="#sub-item-2">
                    <span><svg class="glyph stroked flag"><use xlink:href="#stroked-flag"/></svg> Past Projects </span>
                </a>
                <ul class="children collapse" id="sub-item-2">
                    <li>
                        <a class="" href="#">
                            <svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg> 
                            Project Mars
                        </a>
                    </li>
                    <li>
                        <a class="" href="#">
                            <svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg> 
                            Project Jupiter
                        </a>
                    </li>
                </ul>
            </li>
            <li role="presentation" class="divider"></li>
            <!-- <li><a href="login.html"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Login Page</a></li> -->
            <li>
                <a href="#">
                    <span>
                        <svg class="glyph stroked gear"><use xlink:href="#stroked-gear"/></svg> Settings 
                    </span>
                </a>
            </li>
        </ul>

    </div><!--/.sidebar-->
        
    <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">           
        <div class="row">
            <ol class="breadcrumb">
                <li><a href="#"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
                <li class="active">Dashboard</li>
            </ol>
        </div><!--/.row-->
        
        <div class="row">
            <div class="col-sm-12">
                <h1 class="page-header">Insert Page Title</h1>
                <%-- <p>Project Manager: 
                    <span class="project-manager">Ken Nichols</span> 
                </p>
                <span class="project-settings">
                    <a href="projects/edit/${projects[0].id }">
                        <svg class="glyph stroked gear"><use xlink:href="#stroked-gear"></use></svg>
                    </a>
                </span> --%>
            </div>
        </div><!--/.row-->
        
        
        <div class="row">
        	<div class="col-xs-12">
        		<!--  Insert content here -->
            	Content
        	</div>
            
        </div><!--/.row-->

        
                                
    </div>  <!--/.main-->

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/1.0.2/Chart.js"></script>
    <script src="<c:url value="/resources/js/chart-data.js"/>"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/easy-pie-chart/2.1.6/easypiechart.min.js"></script>
    <script src="<c:url value="/resources/js/easypiechart-data.js" />"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.min.js"></script>
    <script>
        $('#calendar').datepicker({
        });

        !function ($) {
            $(document).on("click","ul.nav li.parent > a > span.icon", function(){          
                $(this).find('em:first').toggleClass("glyphicon-minus");      
            }); 
            $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
        }(window.jQuery);

        $(window).on('resize', function () {
          if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
        })
        $(window).on('resize', function () {
          if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
        })
    </script>   
</body>

</html>