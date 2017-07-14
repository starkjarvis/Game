package game.est.controller;

import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import game.est.service.CheckSecondaryImageService;
import game.est.viewBean.LoginBean;

@Controller
public class SecondaryImagePageController {
	
	@Autowired
	private CheckSecondaryImageService checkSecondaryImageService;
	
	@RequestMapping(value="/secondaryImagePage",method=RequestMethod.POST)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response, LoginBean loginBean, HttpSession session) throws SQLException
	{
		ModelAndView model = new ModelAndView("secondaryImagePage");
		int[] secondary_image=new int[6];
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("loggedInUser", session.getAttribute("loggedInUser"));
		request.setAttribute("loggedInUser", request.getAttribute("loggedInUser"));
		Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/est","root","root");
		int count=0;
		String secondary_images="";
		String query1="select * from playgame where game_id=? and  completed=1";
		PreparedStatement ps1=con1.prepareStatement(query1);
		ps1.setInt(1, Integer.parseInt(session.getAttribute("game_id").toString()));
		ResultSet res1=ps1.executeQuery();
		while(res1.next())
		{
			count++;
			//to show existing chosen 5 secondary images to second player if first has already played
			if(count>0)
			{
				while(res1.next())
					secondary_images=res1.getString("secondary_images_5");
				String[] secondary_images_p2=new String[5];
				secondary_images_p2=secondary_images.split(",");
				/*
				
				request.setAttribute("secondary_image0", secondary_images_p2[0]);
				request.setAttribute("secondary_image1", secondary_images_p2[1]);
				request.setAttribute("secondary_image2", secondary_images_p2[2]);
				request.setAttribute("secondary_image3", secondary_images_p2[3]);
				request.setAttribute("secondary_image4", secondary_images_p2[4]);*/
				return model;
				
			}
			
		}
		
		if(count==0) 
		{
		
			try {
				secondary_image=checkSecondaryImageService.checkSecondaryImage(Integer.parseInt(session.getAttribute("game_id").toString()));
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/est","root","root");
				String query2="insert into playgame(game_id, secondary_image_5) values(?,?)";
				PreparedStatement ps2=con2.prepareStatement(query2);
				ps2.setInt(1, Integer.parseInt(session.getAttribute("game_id").toString()));
				if(secondary_image!=null)
				{
					request.setAttribute("secondary_image0", secondary_image[0]);
					request.setAttribute("secondary_image1", secondary_image[1]);
					request.setAttribute("secondary_image2", secondary_image[2]);
					request.setAttribute("secondary_image3", secondary_image[3]);
					request.setAttribute("secondary_image4", secondary_image[4]);
					
				}
				
				String[] si_5=new String[5];
				for(int i=0;i<5;i++)
					si_5[i]=session.getAttribute("secondary_image"+i).toString();
				String si=String.join(",", si_5);
				
				ps2.setString(2, si);
				ps2.executeUpdate();
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		return model;
	}

}
