<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Emoodicon - Dashboard</title>

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
                                                    <li><a href="${pageContext.request.contextPath}/calendar"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Calendar</a></li>
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
            <li class="active"><a href="/springmvc"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-dashboard-dial"></use></svg> Dashboard</a></li>

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
                <ul class="children collapse in" id="sub-item-1">
                	<c:forEach items="${projects}" var="proj" varStatus="projCounter">
                		<c:choose>
	                		<c:when test="${projCounter.count > 1}">
	                			<li>
			                        <a href="#">
			                            <svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg> 
			                            <c:out value="${proj.name}" />
			                        </a>
			                    </li>
	                		</c:when>
	                		<c:otherwise>
	                			<li class="active-project">
			                        <a href="#">
			                            <svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg> 
			                            <c:out value="${proj.name}" />
			                        </a>
			                    </li>
	                		</c:otherwise>
	                	</c:choose>
                		
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
            <li><a href="${pageContext.request.contextPath}/projectList.htm"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg> Project management</a></li>
            
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
                <h1 class="page-header">${projects[0].name}</h1>
                <p>Project Manager: 
                    <span class="project-manager">${projects[0].projectManager}</span> 
                </p>
                <span class="project-settings">
                    <a href="projects/edit/${projects[0].id }">
                        <svg class="glyph stroked gear"><use xlink:href="#stroked-gear"></use></svg>
                    </a>
                </span>
            </div>
        </div><!--/.row-->
        
        <div class="row">
            <div class="col-xs-12 col-md-6 col-lg-3">
                <div class="panel panel-red panel-widget">
                    <div class="row no-padding">
                        <div class="col-sm-3 col-lg-5 widget-left">
                            <svg class="glyph stroked heart"><use xlink:href="#stroked-heart"/></svg>
                        </div>
                        <div class="col-sm-9 col-lg-7 widget-right">
                            <div class="large">Happy</div>
                            <div class="text-muted">Overall Mood</div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-md-6 col-lg-3">
                <div class="panel panel-blue panel-widget ">
                    <div class="row no-padding">
                        <div class="col-sm-3 col-lg-5 widget-left">
                            <svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg>
                        </div>
                        <div class="col-sm-9 col-lg-7 widget-right">
                            <div class="large">${totalIndex}</div>
                            <div class="text-muted">Index Count</div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-md-6 col-lg-3">
                <div class="panel panel-teal panel-widget">
                    <div class="row no-padding">
                        <div class="col-sm-3 col-lg-5 widget-left">
                            <svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg>
                        </div>
                        <div class="col-sm-9 col-lg-7 widget-right">
                            <div class="large">10</div>
                            <div class="text-muted">Members</div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-md-6 col-lg-3">
                <div class="panel panel-orange panel-widget">
                    <div class="row no-padding">
                        <div class="col-sm-3 col-lg-5 widget-left">
                            <svg class="glyph stroked clipboard with paper"><use xlink:href="#stroked-clipboard-with-paper"/></svg>
                        </div>
                        <div class="col-sm-9 col-lg-7 widget-right">
                            <div class="large">50%</div>
                            <div class="text-muted">Completion</div>
                        </div>
                    </div>
                </div>
            </div>
        </div><!--/.row-->
        
        <div class="row">
            <div class="col-md-8">
                <div class="panel panel-default">
                    <div class="panel-heading"><svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg>Commits / Emotion Index</div>
                    <div class="panel-body">
                        <div class="canvas-wrapper">
                            <canvas class="main-chart" id="line-chart" height="224" width="600"></canvas>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading dark-overlay"><svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"></use></svg>Calendar</div>
                    <div class="panel-body">
                        <div id="calendar"></div>
                    </div>
                </div>
            </div>
        </div><!--/.row-->

        <div class="row">
            <div class="col-md-6">
            
                <div class="panel panel-default chat">
                    <div class="panel-heading" id="accordion"><svg class="glyph stroked clipboard with paper"><use xlink:href="#stroked-clipboard-with-paper"/></svg>Recent Commits</div>
                    <div class="panel-body">
                        <ul>
                            <li class="left clearfix">
                                <span class="chat-img pull-left">
                                    <img src="http://placehold.it/80/30a5ff/fff" alt="User Avatar" class="img-circle" />
                                </span>
                                <div class="chat-body clearfix">
                                    <div class="header">
                                        <strong class="primary-font">9d9b202</strong> 
                                        <small>by Some Person</small>
                                        <small class="text-muted">32 mins ago</small>
                                    </div>
                                    <p>
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ante turpis, rutrum ut ullamcorper sed, dapibus ac nunc. 
                                    </p>
                                </div>
                            </li>
                            <li class="left clearfix">
                                <span class="chat-img pull-left">
                                    <img src="http://placehold.it/80/30a5ff/fff" alt="User Avatar" class="img-circle" />
                                </span>
                                <div class="chat-body clearfix">
                                    <div class="header">
                                        <strong class="primary-font">b16d997</strong> 
                                        <small>by Some Person</small>
                                        <small class="text-muted">35 mins ago</small>
                                    </div>
                                    <p>
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ante turpis, rutrum ut ullamcorper sed, dapibus ac nunc. 
                                    </p>
                                </div>
                            </li>
                            <li class="left clearfix">
                                <span class="chat-img pull-left">
                                    <img src="http://placehold.it/80/30a5ff/fff" alt="User Avatar" class="img-circle" />
                                </span>
                                <div class="chat-body clearfix">
                                    <div class="header">
                                        <strong class="primary-font">e2c79bc</strong> 
                                        <small>by Some Person</small>
                                        <small class="text-muted">50 mins ago</small>
                                    </div>
                                    <p>
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ante turpis, rutrum ut ullamcorper sed, dapibus ac nunc. 
                                    </p>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
                
            </div><!--/.col-->
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading"><svg class="glyph stroked heart"><use xlink:href="#stroked-heart"/></svg>Overall Emotion Percentage</div>
                    <div class="panel-body">
                        <div class="canvas-wrapper">
                            <canvas class="chart" id="pie-chart" ></canvas>
                        </div>
                    </div>
                </div>
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