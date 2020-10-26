package com.restaurantly.customer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.restaurantly.customer.vo.CustomerVO;

@Controller("customerController")
@RequestMapping(value ="/customer")
public class CustomerControllerImpl implements CustomerController {

	@Override
	@RequestMapping(value = "/memberList.do", method = RequestMethod.GET)
	public ModelAndView listmember(CustomerVO customerVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		return null;
	}

	@Override
	@RequestMapping(value = "/addCustomer.do", method = RequestMethod.POST)
	public ModelAndView addmember(@ModelAttribute("CustomerVO") CustomerVO customer, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		return null;
	}

	@Override
	@RequestMapping(value = "/Customer.do", method = RequestMethod.POST)
	public ModelAndView modmember(CustomerVO customerVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		return null;
	}

	@Override
	public ModelAndView deletemember(CustomerVO customerVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return null;
	}

}
