package game.est.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import game.est.viewBean.LoginBean;

@Controller
public class MyHighScore {
	
	@RequestMapping(value="/myHighScore",method=RequestMethod.GET)
	public ModelAndView highScore(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException
	{
		ModelAndView model = new ModelAndView("myHighScore");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/est","root","root");
		String query="select * from login where email=?";
		PreparedStatement ps=con.prepareStatement(query);
		int high_score=0;
		ps.setString(1, session.getAttribute("loggedInUser").toString());
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			high_score=rs.getInt("high_score");
		}
		session.setAttribute("high_score", high_score);
		return model;
	}

}
