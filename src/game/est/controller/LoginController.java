package game.est.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import game.est.delegate.LoginDelegate;
import game.est.viewBean.LoginBean;
import javax.sql.DataSource;

@Controller
public class LoginController
{
		
		static int count=0;
		@Autowired
		private LoginDelegate loginDelegate;

		@RequestMapping(value="/login",method=RequestMethod.GET)
		public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response, LoginBean loginBean)
		{
			ModelAndView model = new ModelAndView("login");
			//LoginBean loginBean = new LoginBean();
			model.addObject("loginBean", loginBean);
			return model;
		}
		@RequestMapping(value="/login",method=RequestMethod.POST)
		public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean")LoginBean loginBean, HttpSession session)
		{
				ModelAndView model= null;
				try
				{
						String usertype = loginDelegate.isValidUser(loginBean.getUsername(), loginBean.getPassword());
						if(usertype!="null" && usertype.equalsIgnoreCase("admin"))
						{
								
								request.setAttribute("loggedInUser", loginBean.getUsername());
								model = new ModelAndView("admin");
								System.out.println("Active players: "+count);
								session.setAttribute("loggedInUser", loginBean.getUsername());
								
								//Change status
								String query="update login set status='online' where email=?";
								try {
									Class.forName("com.mysql.jdbc.Driver");
								} catch (ClassNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/est","root","root");
								PreparedStatement ps=con.prepareStatement(query);
								ps.setString(1, loginBean.getUsername());
								ps.executeUpdate();
								
						
								
								
						}
						else if(usertype!="null" && usertype.equalsIgnoreCase("player"))
						{
							request.setAttribute("loggedInUser", loginBean.getUsername());
							session.setAttribute("loggedInUser", loginBean.getUsername());
							model = new ModelAndView("player");
							count++;
							System.out.println("Active players: "+count);
							session.setAttribute("count", count);
							
							String query="update login set status='online' where email=?";
							try {
								Class.forName("com.mysql.jdbc.Driver");
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/est","root","root");
							PreparedStatement ps=con.prepareStatement(query);
							ps.setString(1, loginBean.getUsername());
							ps.executeUpdate();
							
						}
						else {
							model=new ModelAndView("login");
							request.setAttribute("noRecord", "Please use correct credentials or register!");
						}

				}
				catch(Exception e)
				{
						e.printStackTrace();
				}

				return model;
		}
}
