package com.restaurantly.common.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.restaurantly.customer.vo.CustomerVO;
import com.restaurantly.owner.user.vo.OwnerVO;

public class BaseController {
	@RequestMapping(value = { "*/*Form.do", "*/*/*Form.do" }, method = { RequestMethod.POST, RequestMethod.GET })
	protected ModelAndView viewForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		System.out.println(viewName);

		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "/userSessionCheck.do", method = { RequestMethod.POST, RequestMethod.GET })
	protected String sessionCheck(@RequestParam("user") String user, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		System.out.println(viewName);
		HttpSession session = request.getSession();
		
		String str = null;
		System.out.println(user);
		if (user.equals("customer")) {
			CustomerVO cus = (CustomerVO)session.getAttribute(user);
			str = cus.getCustomer_id();
		}else if(user.equals("owner")) {
			OwnerVO own = (OwnerVO)session.getAttribute(user);			
			str = own.getOwner_id();
		}
		
		return str;
	}
}
