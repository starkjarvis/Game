package game.est.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.xml.bind.ParseConversionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import game.est.service.MyOngoingGameService;
import game.est.service.SearchPlayerService;
import game.est.viewBean.LoginBean;

@Controller
public class SearchPlayerController {
	
	
	@Autowired
	private SearchPlayerService searchPlayerService;
	
	@Autowired
	private MyOngoingGameService myOngoingGameService;
	
	private DataSource dataSource;
	public DataSource getDataSource()
	{
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
	
	@RequestMapping(value="/searchPlayer",method=RequestMethod.POST)
	public ModelAndView searchPlayer(HttpServletRequest request, HttpServletResponse response, LoginBean loginBean, HttpSession session)
	{
		
		int randomNum = 1 + (int)(Math.random() * 20000);
		
		ModelAndView model = new ModelAndView("playGame");
		String username="";
		try {
			//checking whether player has a game_id created
			String result=myOngoingGameService.myOngoingGame(session.getAttribute("loggedInUser").toString());
			if(result.substring(0, result.indexOf('+')).equalsIgnoreCase("yes"))
			{
				request.setAttribute("game_id", Integer.parseInt(result.substring(result.indexOf('+'), result.length())));
				session.setAttribute("game_id", Integer.parseInt(result.substring(result.indexOf('+'), result.length())));
				session.setAttribute("loggedInUser", session.getAttribute("loggedInUser"));
				request.setAttribute("loggedInUser", request.getAttribute("loggedInUser"));
				return model;
				
			}else {
				//getting username of opponent
				username=searchPlayerService.searchPlayer(session.getAttribute("loggedInUser").toString());
			
				//setting my and opponent playing status to 1
				String query1="update login set playing=1 where email=?";
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/est","root","root");
				PreparedStatement pstmt1=con1.prepareStatement(query1);
				pstmt1.setString(1, username);
				pstmt1.executeUpdate();
			
				
				String query2="update login set playing=1 where email=?";
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/est","root","root");
				PreparedStatement pstmt2=con2.prepareStatement(query2);
				pstmt2.setString(1, session.getAttribute("loggedInUser").toString());
				pstmt2.executeUpdate();
			
			
				//updating game table with both username and game_id
				String query3="insert into game values(?,?)";
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Connection con3=DriverManager.getConnection("jdbc:mysql://localhost:3306/est","root","root");
				PreparedStatement pstmt3=con3.prepareStatement(query3);
				pstmt3.setString(1, username);
				System.out.println("Username1 : "+username);
				pstmt3.setInt(2, randomNum);
				System.out.println("Random number 1: "+randomNum);
				pstmt3.executeUpdate();
				
				
				String query4="insert into game values(?,?)";
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Connection con4=DriverManager.getConnection("jdbc:mysql://localhost:3306/est","root","root");
				PreparedStatement pstmt4=con4.prepareStatement(query4);
				pstmt4.setString(1, session.getAttribute("loggedInUser").toString());
				System.out.println("Username2 : "+session.getAttribute("loggedInUser").toString());
				pstmt4.setInt(2, randomNum);
				System.out.println("Random number2: "+randomNum);
				session.setAttribute("game_id", randomNum);
				request.setAttribute("game_id", randomNum);
				pstmt4.executeUpdate();
				
			
				session.setAttribute("loggedInUser", session.getAttribute("loggedInUser"));
				request.setAttribute("loggedInUser", request.getAttribute("loggedInUser"));
			
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

}
