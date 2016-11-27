<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

  <head>
    <title>Signup to Emoodicon</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Arimo|Open+Sans|Roboto:100,300,400" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="${weppappRoot}/springmvc/resources/css/materialize.min.css">
    <link rel="stylesheet" href="${weppappRoot}/springmvc/resources/css/style-login.css">
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha256-/SIrNqv8h6QGKDuNoLGA4iret+kyesCkHGzVUUV0shc=" crossorigin="anonymous"></script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.3/angular.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.3/angular-route.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/js/materialize.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <script type="text/javascript">
    // $() is a function.
    // document refers to Jquery's main document
    // .keyup() is when user releases any key on the keyboard

    // .addClass and .removeClass adds and remove a css class to a tag

    function onLoad() {
        $("#password").keyup(checkPasswordsMatch);
        $("#confirmpassword").keyup(checkPasswordsMatch);


        $("#form").submit(canSubmit);
        $("#form").submit(checkIfUsernameLongerThanFiveChars);
        $("#form").submit(checkIfPasswordLongerThanSevenChars);
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
  <body class="login">
    <div class="container-fluid full-container">
      <div class="container-fluid">
        <div class="container">
          <div class="row">
          	<div class="col-sm-8">
          		<h2>e<span>mood</span>icon</h2>
          		
    			<div class="col-sm-12 tagline">
     				<h4>Keep track of your team's emotions intelligently.</h4>
     				<h5>Analyse how productivity is impacted, and more.</h5>
     			</div>
          			
          	</div>
            <div class="col-sm-4 login-box">
                    <c:if test = "${param.error != null}">
			            <div class="alert alert-danger" role="alert">
			              <strong>Username already exists</strong>
			            </div>
				    </c:if>
				      <div class="alert" id="matchpassword"></div>
				    <sf:form id="form" method="post"
			            action="${pageContext.request.contextPath}/createaccount"
			            commandName="user">
				      		<div class="input-field col s12">Username
                    <sf:input id="username" class="control" path="username" name="username"
                    type="text" placeholder="Username" />
<<<<<<< HEAD
	       				   
=======
>>>>>>> 30b78a13d6beacd0fca56381ce6b25c2cd1996dd
                    <div class="error">
                        <sf:errors path="username"></sf:errors>
                    </div>
			           </div>
			           <div class="input-field col s12">Password
                    <sf:input id="password" class="control" path="password"
                        name="password" type="password" placeholder="Password"/>
<<<<<<< HEAD
			            	
=======
>>>>>>> 30b78a13d6beacd0fca56381ce6b25c2cd1996dd
                    <div class="error">
                        <sf:errors path="password"></sf:errors>
                    </div>
			           </div>
                 <div class="input-field col s12">
                 Confirm Password
                    <input id="confirmpassword" class="control"
                    name="confirmpassword" type="password" placeholder="Confirm Password" />
<<<<<<< HEAD

=======
>>>>>>> 30b78a13d6beacd0fca56381ce6b25c2cd1996dd
                 </div>

			           <div class="col s12">
	            		<input class="btn col s12 control" name="submit" type="submit"
		                    value="Sign Up" />
			           </div>
		                

		                <!-- <input type="hidden" name="${_csrf.parameterName}"
		                    value="${_csrf.token}" /> -->
				    </sf:form>
				    <div class="col s12 signup-link">
					    Already have an account?<a href= "<c:url value = "/login"/>"> Login here!</a>
					    <!--  Some fancy way to add a new URL over pageContext.request.contextPath -->
				    </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>