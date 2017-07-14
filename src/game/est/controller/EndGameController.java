package game.est.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import game.est.viewBean.LoginBean;

@Controller
public class EndGameController {
	
	@RequestMapping(value="/endGame",method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, HttpSession session, LoginBean loginBean) throws SQLException
	{
		ModelAndView model = new ModelAndView("login");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con5=DriverManager.getConnection("jdbc:mysql://localhost:3306/est","root","root");
		String query="delete from game where game_id=?";
		PreparedStatement ps=con5.prepareStatement(query);
		ps.setInt(1, Integer.parseInt(session.getAttribute("game_id").toString()));
		ps.executeUpdate();
		
		String query2="delete from playgame where game_id=?";
		PreparedStatement ps2=con5.prepareStatement(query2);
		ps2.setInt(1, Integer.parseInt(session.getAttribute("game_id").toString()));
		ps2.executeUpdate();
		
		String query3="update login set status=?,playing=0 where email=?";
		PreparedStatement ps3=con5.prepareStatement(query3);
		ps3.setString(1, "offline");
		ps3.setString(2, session.getAttribute("loggedInUser").toString());
		ps3.executeUpdate();
		
		return model;
	}

}
