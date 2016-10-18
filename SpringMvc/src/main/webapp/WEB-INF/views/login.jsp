<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
  <head>
    <title>Login to Emoodicon</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Arimo|Open+Sans|Roboto">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="${weppappRoot}/springmvc/resources/css/materialize.min.css">
    <link rel="stylesheet" href="${weppappRoot}/springmvc/resources/css/style-login.css">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/js/materialize.min.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.3/angular.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.3/angular-route.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
  </head>
  <body class="login">
    <div class="container-fluid">
      <div class="container-fluid">
        <div class="container">
          <div class="row">
            <div class="col-sm-4 col-sm-offset-4 login-box">
            <h1>e<span>mood</span>icon</h1>
				    <c:if test = "${param.error != null}">
				    <p class="error">[!] Login failed. Check your username and password. [!]</p>
				    </c:if>
				
				    <form name='login'
				        action="<c:url value='j_spring_security_check' />"
				        method='POST'>
				        <span>
			                <label>USERNAME</label>
			                <input type='text' name='username' value='' />
		       			</span>
		       			<span>
			                <label>PASSWORD</label>
			                <input type='password' name='password' />
			            </span>
			            <span>
		                <input class="btn" name="submit" type="submit"
		                    value="Login" />
		                </span>
		                <input type="hidden" name="${_csrf.parameterName}"
		                    value="${_csrf.token}" />
				    </form>
				    
				    Don't have an account? <p><a href= "<c:url value = "/newaccount"/>"> Sign up now!</a></p>
				    <!--  Some fancy way to add a new URL over pageContext.request.contextPath -->
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>