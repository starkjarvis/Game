<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Score!!</title>
</head>
<body>
<%@include file="navigationBar.jsp"%>
	<center><br><br><br>
	<div class="container header-content">
			<%System.out.println(session.getAttribute("completedStatus")); %>
			<%String completedStatus=session.getAttribute("completedStatus").toString();
				if(completedStatus.equalsIgnoreCase("no")){
					%><h3>Second Player has not completed the game yet. Please press Refresh to check again.</h3><br>
						<form action="calculateScore" method="post">
							<input type="submit" value="Refresh" style="width:20%;" class="btn btn-lg btn-primary btn-block" />
						</form><%
				}
				else if(completedStatus.equalsIgnoreCase("yes"))
				{
					%><h3>Your Score is: ${score}</h3><%
					
					//adding high score to login table
					try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/est","root","root");
					String query1="select * from login where email=?";
					int high_score=0;
					PreparedStatement ps1=con1.prepareStatement(query1);
					ps1.setString(1, session.getAttribute("loggedInUser").toString());
					ResultSet rs1=ps1.executeQuery();
					while(rs1.next())
						high_score=rs1.getInt("high_score");
					
					if(Integer.parseInt(session.getAttribute("score").toString())>high_score)
					{
						String query2="update login set high_score=? where email=?";
						PreparedStatement ps2=con1.prepareStatement(query2);
						ps2.setInt(1, Integer.parseInt(session.getAttribute("score").toString()));
						ps2.setString(2, session.getAttribute("loggedInUser").toString());
						ps2.executeUpdate();
						
					}
						
					
				}
				
			%>
			<%session.setAttribute("loggedInUser", session.getAttribute("loggedInUser")); %>
			<br>
			<form action="nextGame" method="post">
			<%session.setAttribute("loggedInUser", session.getAttribute("loggedInUser")); %>
				<input type="submit" value="NextGame" style="width:20%;" class="btn btn-lg btn-primary btn-block" /><br><br>
			</form>
		</div>
	</center>
	
</body>
</html>