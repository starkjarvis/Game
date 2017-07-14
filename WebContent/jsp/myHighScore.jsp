<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your High Score</title>
</head>
<body>
	<%@include file="navigationBar.jsp"%>
	<center><br><br>
		<div class="container header-content">
			<div class="row">
				<h3>Your High Score till now is: <%=session.getAttribute("high_score") %></h3>
			</div>
			<br>
			<form action="endGame" method="get">
				<input type="submit" value="Search player again" style="width:20%;" class="btn btn-lg btn-primary btn-block" />
			</form>
			
		</div>
	</center>
</body>
</html>