<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome <%=session.getAttribute("loggedInUser") %></title>
</head>
<body>
	<center><h1>Welcome Admin to EST Game</h1></center>
	<center>
		<h1>Welcome <%=session.getAttribute("loggedInUser") %></h1>
		
		<p>Search a player: 
		<form action="searchPlayer" method="post">
			<input type="submit" value="search">
		</form>
		
	</center>
</body>
</html>