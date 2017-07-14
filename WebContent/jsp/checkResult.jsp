<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Click</title>
</head>
<body>
	<%@include file="navigationBar.jsp"%>
	<%session.setAttribute("loggedInUser", session.getAttribute("loggedInUser"));
			request.setAttribute("loggedInUser", request.getAttribute("loggedInUser")); %>
	<center><br><br><br>
		<div class="container header-content">
			<h1>Your result is a click away.</h1>
			<form method="post" action="calculateScore">
				<input type="submit" value="Click Here!" style="width:20%;" class="btn btn-lg btn-primary btn-block" /><br><br>
			</form>
		</div>
	</center>
	
	
</body>
</html>