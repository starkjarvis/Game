package game.est.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import game.est.service.AreCompetitorsService;
import game.est.viewBean.LoginBean;


@Controller
public class PlayGameController {
	
	@Autowired
	private AreCompetitorsService areCompetitorsService;
	
	@RequestMapping(value="/playGame",method=RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response, LoginBean loginBean, HttpSession session) throws SQLException
	{
		ModelAndView model = new ModelAndView("playGame");
		String player1=session.getAttribute("loggedInUser").toString();
		String temp=areCompetitorsService.areCompetitors(session.getAttribute("loggedInUser").toString());
		String player2=temp.substring(0, temp.indexOf('+'));
		int game_id=Integer.parseInt(temp.substring(temp.indexOf('+'), temp.length()));
		
		request.setAttribute("player1", player1);
		request.setAttribute("player2", player2);
		request.setAttribute("game_id", game_id);
		session.setAttribute("game_id", game_id);
		System.out.println("Game_ID: "+session.getAttribute("game_id"));
		model.addObject("loginBean", loginBean);
		session.setAttribute("loggedInUser", session.getAttribute("loggedInUser"));
		request.setAttribute("loggedInUser", request.getAttribute("loggedInUser"));
		return model;
	}
	

}
