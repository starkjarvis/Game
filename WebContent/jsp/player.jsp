<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Welcome <%=session.getAttribute("loggedInUser") %></title>
</head>
<body>
	<%@include file="navigationBar.jsp"%>
	<center>
	<div class="container header-content">
		<div class="row">
			<h1>Welcome <%=session.getAttribute("loggedInUser") %></h1>
			<%session.setAttribute("loggedInUser", session.getAttribute("loggedInUser"));
			request.setAttribute("loggedInUser", request.getAttribute("loggedInUser")); %>
			<p>Search a player: 
			<form action="searchPlayer" method="post">
				<%session.setAttribute("game_id", session.getAttribute("game_id")); %>
				<input type="submit" value="Search" style="width:20%;" class="btn btn-lg btn-primary btn-block" />
			</form>
		</div>
	</div>
		
	</center>
	
	

</body>
</html>