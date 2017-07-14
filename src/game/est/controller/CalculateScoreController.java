package game.est.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import game.est.service.CheckCompletedService;
import game.est.viewBean.LoginBean;

@Controller
public class CalculateScoreController {
	
	@Autowired
	private CheckCompletedService checkCompletedService;
	
	@RequestMapping(value="/calculateScore",method=RequestMethod.POST)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws NumberFormatException, SQLException
	{	int count=0;
		ModelAndView model = new ModelAndView("calculateScore");
		System.out.println("Hello Controller");
		session.setAttribute("loggedInUser", session.getAttribute("loggedInUser"));
		request.setAttribute("loggedInUser", request.getAttribute("loggedInUser"));
		//check whether both players have completed the game or not.
		String completed=checkCompletedService.checkCompleted(Integer.parseInt(session.getAttribute("game_id").toString()));
		if(completed.equalsIgnoreCase("no")) {
			session.setAttribute("completedStatus", "no");
			return model;
		}
		else if(completed.equalsIgnoreCase("yes"))
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/est","root","root");
			String query1="select * from playgame where game_id=? and completed=2";
			String si_p1="";
			String si_p2="";
			
			PreparedStatement ps1=con1.prepareStatement(query1);
			ps1.setInt(1, Integer.parseInt(session.getAttribute("game_id").toString()));
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next())
			{
				si_p1=rs1.getString("secondary_images_p1");
		        String[] items1=si_p1.split(",");
		        int[] results1 = new int[items1.length];
		        for (int i = 0; i < items1.length; i++) {
		            try {
		                results1[i] = Integer.parseInt(items1[i]);
		               
		            } catch (NumberFormatException nfe) {
		            //NOTE: write something here if you need to recover from formatting errors
		            };
		        }
				si_p2=rs1.getString("secondary_image_p2");
				String[] items2=si_p2.split(",");
			    int[] results2 = new int[items2.length];
			    for (int i = 0; i < items2.length; i++) 
			    {
			    	try {
			    		results2[i] = Integer.parseInt(items2[i]);
			               
			        } catch (NumberFormatException nfe) {
			            //NOTE: write something here if you need to recover from formatting errors
			        };
			    }
			    
			
				//calculating score
			    
			    int size1=results1.length;
			    int size2=results2.length;
			    System.out.println("Size1: "+size1);
			    System.out.println("Size2: "+size2);
			    if(size1>size2 || size1==size2)
			    {
			    	for(int i=0;i<size1;i++) {
			    		for(int j=0;j<size2;j++)
			    		{
			    			if(results1[i]==results2[j])
			    				count++;
			    		}
			    	}
			    }
			    
			    else if(size1<size2)
			    {
			    	for(int i=0;i<size2;i++) {
			    		for(int j=0;j<size1;j++)
			    		{
			    			if(results2[i]==results1[j])
			    				count++;
			    		}
			    	}
			    }
			    System.out.println("Count: "+count);
			}
			session.setAttribute("completedStatus", "yes");
			session.setAttribute("score", count);
		}
		session.setAttribute("completedStatus", "yes");
		session.setAttribute("score", count);
		
		return model;
	}

}
