<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Random"%>
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
	<center>
		<div class="container header-content">
			<center><h1>Try your Luck!</h1><center>
			<h3>Your Username: <%=session.getAttribute("loggedInUser") %></h3>
			<h3>Game ID: ${game_id}</h3>
			
			<%session.setAttribute("game_id", request.getAttribute("game_id")); %>
			<%session.setAttribute("loggedInUser", session.getAttribute("loggedInUser"));
			request.setAttribute("loggedInUser", request.getAttribute("loggedInUser")); %>
			<%
				Random rand = new Random();
				
				int primary_image=0;
				//inserting primary_image in playgame table
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/est","root","root");
				String query="select * from playgame where game_id=? and completed=1";
				int count=0;
				String si_5="";
				
				PreparedStatement ps=con1.prepareStatement(query);
				ps.setInt(1, Integer.parseInt(request.getAttribute("game_id").toString()));
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					count++;
					System.out.println("Count: "+count);
					if(count>0)
					{
						si_5=rs.getString("secondary_image_5");
						primary_image=rs.getInt("primary_image");
						System.out.println("Primary Image: "+primary_image);
						session.setAttribute("primary_image", primary_image);
						String[] si=new String[5];
						si=si_5.split(",");
					
						int i=0;
						for(int j=0;j<5;j++){
							session.setAttribute("secondary_image"+j, si[j]);
							
						}
						String query1="insert into playgame(primary_image, game_id) values(?,?) ";
						PreparedStatement ps1=con1.prepareStatement(query1);
						ps1.setInt(1, Integer.parseInt(session.getAttribute("primary_image").toString()));
						
						ps1.setInt(2, Integer.parseInt(request.getAttribute("game_id").toString()));
						ps1.executeUpdate();
						System.out.println("Primary: "+Integer.parseInt(session.getAttribute("primary_image").toString()));
						
					}
				}
				if(count==0){
					String query1="insert into playgame(primary_image, game_id) values(?,?) ";
					PreparedStatement ps1=con1.prepareStatement(query1);
					primary_image = rand.nextInt((15 - 1) + 1) + 1;
					System.out.println("Primary image: "+primary_image);
					session.setAttribute("primary_image", primary_image);
					ps1.setInt(1, primary_image);
					
					ps1.setInt(2, Integer.parseInt(request.getAttribute("game_id").toString()));
					ps1.executeUpdate();
					
					int[] secondary_images=new int[6];
					for(int i=0;i<5;i++)
						secondary_images[i]=0;
					int temp=0;
					int i=0;
					while(i!=5)
					{
						temp=rand.nextInt((15 - 1) + 1) + 1;
						if(temp!=primary_image && temp!=secondary_images[0] && temp!=secondary_images[1] && temp!=secondary_images[2] && temp!=secondary_images[3] && temp!=secondary_images[4]){
							secondary_images[i]=temp;
							session.setAttribute("secondary_image"+i, temp);
							i++;
						}
							
					}
				
				}
					
				
				
			%>
				<h2>Here is your Primary Image. Based on this image, select(or not) next 5 images, appropriate according to you.</h2>
				<br>
				<form action="secondaryImagePage" method="post">
					
					<image src="img/<%=primary_image%>.jpg" height="300" width="500"><br><br>
					<%session.setAttribute("primary_image",primary_image); %>
					
					<input type="submit" value="Next" style="width:20%;" class="btn btn-lg btn-primary btn-block" />
				</form>
				<br><br>
			</div>
	</center>
		
	
</body>
</html>