package game.est.controller;

import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import game.est.viewBean.LoginBean;

@Controller
public class CheckResultController {
	
	@RequestMapping(value="/checkResult",method=RequestMethod.POST)
	public ModelAndView checkResult(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException
	{
		ModelAndView model=new ModelAndView("checkResult");
		session.setAttribute("loggedInUser", session.getAttribute("loggedInUser"));
		request.setAttribute("loggedInUser", request.getAttribute("loggedInUser"));
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con5=DriverManager.getConnection("jdbc:mysql://localhost:3306/est","root","root");
		//checking whether there is record for completed=1 so that values are inserted in secondary_image_p2
		int count5=0;
		String query5="select * from playgame where completed=1 and game_id=?";
		PreparedStatement ps5=con5.prepareStatement(query5);
		ps5.setInt(1, Integer.parseInt(session.getAttribute("game_id").toString()));
		ResultSet res5=ps5.executeQuery();
		while(res5.next())
		{
			count5++;
			if(count5>0)
			{
				String query6="update playgame set secondary_image_p2=?, completed=? where game_id=? and completed=?";
				PreparedStatement ps6=con5.prepareStatement(query6);
				String[] secondary_images1=request.getParameterValues("secondaryImage");
				String secondary_images = String.join(",", secondary_images1);
				ps6.setString(1, secondary_images);
				ps6.setInt(2, 2);
				ps6.setInt(3, Integer.parseInt(session.getAttribute("game_id").toString()));
				ps6.setInt(4, 1);
				ps6.executeUpdate();
				
				String query7="delete from playgame where game_id=? and completed=0";
				PreparedStatement ps7=con5.prepareStatement(query7);
				ps7.setInt(1, Integer.parseInt(session.getAttribute("game_id").toString()));
				ps7.executeUpdate();
			}
			//else values are inserted in secondary_image_p1
			
		}
		if(count5==0) {
			//update playgame table
			int game_id=Integer.parseInt(session.getAttribute("game_id").toString());
			String[] secondary_images1=request.getParameterValues("secondaryImage");
			

			String secondary_images = String.join(",", secondary_images1);
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/est","root","root");
			int primary_image=0;
			String query2="select primary_image from playgame where game_id=?";
			PreparedStatement ps2=con1.prepareStatement(query2);
			ps2.setInt(1, game_id);
			ResultSet res2=ps2.executeQuery();
			while(res2.next())
			{
				primary_image=res2.getInt("primary_image");
			}
			
			String query4="select * from playgame where game_id=?";
			String secondary_image_5="";
			PreparedStatement ps4=con1.prepareStatement(query4);
			ps4.setInt(1, game_id);
			ResultSet res4=ps4.executeQuery();
			while(res4.next())
				secondary_image_5=res4.getString("secondary_image_5");
			
				
			
			
			String query1="insert into playgame(game_id, completed, secondary_images_p1, primary_image,secondary_image_5) values(?,?,?,?,?)";
			PreparedStatement ps1=con1.prepareStatement(query1);
			ps1.setInt(1, game_id);
			ps1.setInt(2, 1);
			ps1.setString(3, secondary_images);
			ps1.setInt(4, Integer.parseInt(session.getAttribute("primary_image").toString()));
			ps1.setString(5, secondary_image_5);
			
			ps1.executeUpdate();
			
			String query3="delete from playgame where game_id=? and completed=0";
			PreparedStatement ps3=con1.prepareStatement(query3);
			ps3.setInt(1, game_id);
			ps3.executeUpdate();
		}
		
		return model;
	}
	

}
	