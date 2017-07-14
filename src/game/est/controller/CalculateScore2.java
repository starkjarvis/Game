package game.est.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import game.est.viewBean.LoginBean;

@Controller
public class CalculateScore2 {
	
	@RequestMapping(value="/calculateScore2",method=RequestMethod.POST)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		ModelAndView model = new ModelAndView("calculateScore2");
		session.setAttribute("loggedInUser", session.getAttribute("loggedInUser"));
		request.setAttribute("loggedInUser", request.getAttribute("loggedInUser"));
		return model;
	}

}
