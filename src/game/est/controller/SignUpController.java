package game.est.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
public class SignUpController {
	
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response, LoginBean loginBean)
	{
		ModelAndView model = new ModelAndView("SignUp");
		
		
		return model;
	}

	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException
	{
		ModelAndView model=new ModelAndView("SignUp");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/est","root","root");
		String fullName=request.getParameter("fullName");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String dateOfBirth=request.getParameter("dateOfBirth");
		String gender=request.getParameter("gender");
		
		String query="insert into registration values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, fullName);
		ps.setString(2, email);
		ps.setString(3, password);
		ps.setString(4, dateOfBirth);
		ps.setString(5, gender);
		
		ps.executeUpdate();
		
		request.setAttribute("registrationComplete", "Registration Done. Login to continue.");
		
		String query1="insert into login(email, password, usertype, playing) value(?,?,?,0)";
		PreparedStatement ps1=con.prepareStatement(query1);
		ps1.setString(1, email);
		ps1.setString(2, password);
		ps1.setString(3, "player");
		ps1.executeUpdate();
		
		
		return model;
	}
}
