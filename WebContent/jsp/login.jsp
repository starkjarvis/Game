<%@include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		 <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

    <!-- Plugin CSS -->
    <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

    <!-- Theme CSS -->
    <link href="css/creative.min.css" rel="stylesheet">
		<title>Login</title>
	</head>
	<body>
		
		<br><br><br><br><br><br><br><br>
		<!-- <center>
			<form:form id="loginForm" method="post" action="login" modelAttribute="loginBean">
				
				<form:label path="username">Enter your user-name</form:label>
				
				<form:input id="username" name="username" path="" /><br>
				<br>
				<form:label path="username">Please enter your password</form:label>
				<form:password id="password" name="password" path="" /><br>
				<br>
				<input type="submit" value="Submit" />
			</form:form>
		</center> -->
		
		 <center>
    	<div class="container header-content">
            <div class="row">
            <h3 style="color: RED;">${noRecord}</h3>
            
            <h2 class="section-heading">Login</h2>
                    <hr class="primary">
                
                	<form:form id="loginForm" method="post" action="login" modelAttribute="loginBean">

				<span class="style1" class="sr-only" style="color:white; font-size:18px;"><b>Username</b></span>
				<input class="form-control" style="width:50%;" id="username" placeholder="Username" name="username" /><br>
				<span class="style1" class="sr-only" style="color:white; font-size:18px;"><b>Password</b></span>
				<input style="width:50%;" type="password" class="form-control" placeholder="Password" required width="35%" id="password" name="password"  /><br>
				<input type="submit" value="Login" style="width:20%;" class="btn btn-lg btn-primary btn-block" />
				
			</form:form>
			<br>OR &nbsp; <a href="signup" style="font-size:20px; color:BLACK;">Sign Up</a>
			
                
               </div>
               
         </div>
         </center>
	</body>
</html>