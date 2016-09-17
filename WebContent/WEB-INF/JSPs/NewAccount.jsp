<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/static/script/jquery.js"></script>
<script type="text/javascript">
	
	// $() is a function.
	// document refers to Jquery's main document
	// .keyup() is when user releases any key on the keyboard
	
	// .addClass and .removeClass adds and remove a css class to a tag
	
	function onLoad(){
		$("#password").keyup(checkPasswordsMatch);
		$("#confirmpassword").keyup(checkPasswordsMatch);
		
		$("#form").submit(canSubmit);
	}
	
	function canSubmit(){
		var password = $("#password").val();
		var confirmPassword = $("#confirmpassword").val();
		
		if (password == confirmPassword){
			return true;
		}
		
		alert("Passwords do not match.");
		return false;
	}

	function checkPasswordsMatch(){
		var password = $("#password").val();
		var confirmPassword = $("#confirmpassword").val();
		
		
		if (password.length > 7 && confirmPassword.length > 7){
			
			if (password == confirmPassword){
				$("#matchpassword").text("Passwords match");
				$("#matchpassword").removeClass("error");
				$("#matchpassword").addClass("valid");
			} else {
				$("#matchpassword").text("Passwords do not match");
				$("#matchpassword").removeClass("valid");
				$("#matchpassword").addClass("error");
			}
			
		}
		
		
	}
	
	$(document).ready(onLoad);
	
	</script>

<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Create New Account</title>
</head>
<body>

	<h2>Create New Account</h2>

	<sf:form id = "form" method="post"
		action="${pageContext.request.contextPath}/CreateAccount"
		commandName="user">

		<table class="formtable">
			<tr>
				<td class="label">Username:</td>
				<td><sf:input class="control" path="username" name="username"
						type="text" /><br />
					<div class="error">
						<sf:errors path="username"></sf:errors>
					</div></td>
			</tr>
			<tr>
				<td class="label">Email:</td>
				<td><sf:input class="control" path="email" name="email"
						type="text" /><br />
					<div class="error">
						<sf:errors path="email"></sf:errors>
					</div></td>
			</tr>
			<tr>
				<td class="label">Password:</td>
				<td><sf:input id="password" class="control" path="password"
						name="password" type="text" /><br />
					<div class="error">
						<sf:errors path="password"></sf:errors>
					</div></td>
			</tr>
			<tr>
				<td class="label">Confirm Password:</td>
				<td><input id="confirmpassword" class="control"
					name="confirmpassword" type="text" />
				<div id="matchpassword"></div></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input class="control" value="Create account" type="submit" /></td>
			</tr>
		</table>

	</sf:form>

</body>
</html>