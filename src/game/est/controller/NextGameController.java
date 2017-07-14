package game.est.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import game.est.service.NextGameDeleteDataService;
import game.est.viewBean.LoginBean;

@Controller
public class NextGameController {
	
	@Autowired
	private NextGameDeleteDataService nextGameDeleteDataService;
	
	@RequestMapping(value="/nextGame",method=RequestMethod.POST)
	public ModelAndView nextGame(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException
	{
		ModelAndView model = new ModelAndView("player");
		
		//delete data for user from game tables
		
		String result=nextGameDeleteDataService.nextGameDeleteData(Integer.parseInt(session.getAttribute("game_id").toString()));
		
		return model;
	}

}
