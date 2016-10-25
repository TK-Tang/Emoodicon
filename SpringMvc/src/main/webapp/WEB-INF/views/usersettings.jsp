<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Emoodicon - User Settings</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker3.min.css">
<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">

<!--Icons-->
<script src="<c:url value="/resources/js/lumino.glyphs.js" />"></script>

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
    
    <script type="text/javascript">
    // $() is a function.
    // document refers to Jquery's main document
    // .keyup() is when user releases any key on the keyboard

    // .addClass and .removeClass adds and remove a css class to a tag

    function onLoad() {
        $("#password").keyup(checkPasswordsMatch);
        $("#confirmpassword").keyup(checkPasswordsMatch);


        $(".check").submit(canSubmit);
        $(".check").submit(checkIfUsernameLongerThanFiveChars);
        $(".check").submit(checkIfPasswordLongerThanSevenChars);
    }

    function canSubmit() {
        var password = $("#password").val();
        var confirmPassword = $("#confirmpassword").val();

        if (password == confirmPassword) {
            return true;
        }

        alert("Passwords do not match.");
        return false;
    }

    function checkPasswordsMatch() {
        var password = $("#password").val();
        var confirmPassword = $("#confirmpassword").val();

        if (password.length > 7 && confirmPassword.length > 7) {

            if (password == confirmPassword) {
                $("#matchpassword").text("Passwords match");
                $("#matchpassword").removeClass("alert-danger");
                $("#matchpassword").addClass("alert-success");
            } else {
                $("#matchpassword").text("Passwords do not match");
                $("#matchpassword").removeClass("alert-success");
                $("#matchpassword").addClass("alert-danger");
            }

        }

    }
    
    function checkIfPasswordLongerThanSevenChars(){
        var password = $("#password").val();
        
        if (password.length < 7){
            alert("Password must be longer than seven chars");
            return false;
        }
        
        return true;
    }

    function checkIfUsernameLongerThanFiveChars(){
        var username = $("#username").val();
        
        if (username.length < 5){
            alert("Username must be longer than five chars");
            return false;
        }
        
        return true;
    }
    
    $(document).ready(onLoad);
    
</script>

</head>

<body class="user-settings">
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
                                                    <li><a href="${pageContext.request.contextPath}/calendar"><svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"/></svg> Calendar</a></li>
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
            <li><a href="${pageContext.request.contextPath}/projects/add"><svg class="glyph stroked plus sign"><use xlink:href="#stroked-plus-sign"/></svg> Create Project</a></li>
            <li><a href="${pageContext.request.contextPath}/projects/view"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg>Manage Projects</a></li>
            <li class="parent">
                <a data-toggle="collapse" href="#sub-item-1">
                    <span><svg class="glyph stroked star"><use xlink:href="#stroked-star"></use></svg> Current Projects </span>
                </a>
                <ul class="children collapse" id="sub-item-1">
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

                <li><a href="/springmvc/"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
                <li class="active">User Settings</li>
            </ol>
        </div><!--/.row-->
        
        <div class="row">
            <div class="col-sm-12">
                <h1 class="page-header">User Settings</h1>
            </div>
        </div><!--/.row-->
       
        
        
        <div class="row">
        
                <c:if test = "${error != null}">
					<div class="alert alert-danger" role="alert">
			    		<strong>Incorrect password </strong>.
			    	</div>
				</c:if>
				 <c:if test = "${passworderror != null}">
					<div class="alert alert-danger" role="alert">
			    		<strong>New password must be longer than seven characters </strong>.
			    	</div>
				</c:if>
		
		<div class="alert" id="matchpassword"></div>
            <div class="col-xs-12">
                <mvc:form modelAttribute="Users"  class="check" method="post" action="${pageContext.request.contextPath}/usereditprofile" commandName = "user">
                    <table>
                    
                     	<tr>
                            <td><label>Password</label></td>
                            <td><mvc:input path="password" type="password" placeholder="current password" cssErrorClass="formFieldError" /></td>
                            <td><mvc:errors path="password" /></td>
                        </tr>
                        <tr>
                            <td><label for="password">New Password</label></td>
                            <td><mvc:input path="newPassword" type = "password" name="password" id="password" placeholder="new password" /></td>
                        </tr>
                        <tr>
                            <td for="confirmpassword">Confirm Password</td>
                            <td><input name="confirmpassword" id="confirmpassword" placeholder="confirm password" type="password"/>
                        </tr>
                        <tr>
                            <td><mvc:label path="nameFirst">First Name</mvc:label></td>
                            <td><mvc:input path="nameFirst" cssErrorClass="formFieldError" /></td>
                            <td><mvc:errors path="nameFirst" /></td>
                        </tr>
                        <tr>
                            <td><mvc:label path="nameLast">Last Name</mvc:label></td>
                            <td><mvc:input path="nameLast" cssErrorClass="formFieldError" /></td>
                            <td><mvc:errors path="nameLast" /></td>
                        </tr>
                        <tr>
                            <td><mvc:label path="detail">Detail</mvc:label></td>
                            <td><mvc:textarea path="detail" /></td>
                        </tr>
                        <tr>
                            <td><mvc:label path="gender" required>Gender</mvc:label></td>
                            <td><mvc:radiobuttons path="gender" items="${genders}" /></td>
                        </tr>
                        <tr>
                            <td><mvc:label path="country">Country</mvc:label></td>
                            <td><mvc:select path="country" items="${countries}" /></td>
                        </tr>
                        <tr>

                            <td><mvc:label path="nonSmoking" required>Non Smoking</mvc:label></td>
                            <td><mvc:checkbox path="nonSmoking" /></td>
                        </tr>
                        <tr>
                            <td>
                            	<!-- This hidden field is required for Hibernate to recognize this User -->
                                <mvc:hidden path="username" value="${username}"/>
                                <mvc:hidden path="password" value="${password}"/>
                                
                                <input class="btn btn-default" type="submit" value="Save" />
                                <a class="btn btn-default" href="${pageContext.request.contextPath}">Cancel</a>
                            </td>
                            <td>
                          
                            </td>
                        </tr>
                    </table>
                </mvc:form>
            </div>
            
            <hr>
            
        </div><!--/.row-->
                                
    </div>  <!--/.main-->
</body>

</html>