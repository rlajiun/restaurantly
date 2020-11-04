package com.restaurantly.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.restaurantly.common.base.BaseController;

@Controller("mainController")
public class MainController extends BaseController {
	@RequestMapping(value = "/main.do", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session;

		ModelAndView mav = new ModelAndView();
		String viewName = (String) request.getAttribute("viewName");
		mav.setViewName(viewName);

		session = request.getSession();
		session.setAttribute("user", "customer");

		return mav;
	}

	@RequestMapping(value = "/owner/main.do", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView mainOwner(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session;

		ModelAndView mav = new ModelAndView();
		String viewName = (String) request.getAttribute("viewName");
		mav.setViewName(viewName);

		session = request.getSession();
		session.setAttribute("user", "owner");

		return mav;
	}
}