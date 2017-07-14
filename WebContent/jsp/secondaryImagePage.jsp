<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Game Window</title>
</head>
<body>
	<%@include file="navigationBar.jsp"%>
	<div class="container header-content">
		<center>
			<h3>Your Username: <%=session.getAttribute("loggedInUser") %></h3>
			<%session.setAttribute("loggedInUser", session.getAttribute("loggedInUser"));
				request.setAttribute("loggedInUser", request.getAttribute("loggedInUser")); %>
			<h1>Based on the primary image shown in previous page, please select(or not) images from below.</h1>
			<form action="checkResult" method="post">
				
				<img src="img/<%=session.getAttribute("secondary_image0") %>.jpg" height="300" width="500"><br>
				<input type="checkbox" name="secondaryImage" value="<%=session.getAttribute("secondary_image0") %>"><br><br>
				<img src="img/<%=session.getAttribute("secondary_image1") %>.jpg" height="300" width="500"><br>
				<input type="checkbox" name="secondaryImage" value="<%=session.getAttribute("secondary_image1") %>"><br><br>
				<img src="img/<%=session.getAttribute("secondary_image2") %>.jpg" height="300" width="500"><br>
				<input type="checkbox" name="secondaryImage" value="<%=session.getAttribute("secondary_image2") %>"><br><br>
				<img src="img/<%=session.getAttribute("secondary_image3") %>.jpg" height="300" width="500"><br>
				<input type="checkbox" name="secondaryImage" value="<%=session.getAttribute("secondary_image3") %>"><br><br>
				<img src="img/<%=session.getAttribute("secondary_image4") %>.jpg" height="300" width="500"><br>
				<input type="checkbox" name="secondaryImage" value="<%=session.getAttribute("secondary_image4") %>"><br><br>
					
				
				<br><br>
				<input type="submit" value="Next" style="width:20%;" class="btn btn-lg btn-primary btn-block" /><br><br>
				
			</form>
		</center>
	</div>
	
</body>
</html>