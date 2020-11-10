package com.restaurantly.customer.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.restaurantly.common.base.BaseService;
import com.restaurantly.customer.service.CustomerService;
import com.restaurantly.customer.vo.CustomerVO;

//리스트 멤버추가 멤버수정 멤버삭제 맞는지 모르겠음

@Controller("customerController")
@RequestMapping(value = "/customer")
public class CustomerController extends BaseService {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerVO customerVO;

	@ResponseBody
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public Map<String, String> login(@RequestParam Map<String, String> loginMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> ckloginMap = new HashMap<String, String>();
		String msg = null;
		String url = null;
		customerVO = customerService.login(loginMap);
		if (customerVO != null && customerVO.getCustomer_id() != null) {
			HttpSession session = request.getSession();
			session.setAttribute("customer", customerVO);

			String action = (String) session.getAttribute("action");
			if (action != null) {
				url = request.getContextPath() + action +".do";
				session.removeAttribute("action");
			} else {
				url = request.getContextPath() + "/main.do";
			}

		} else {
			msg = "아이디와 비밀번호를 확인해주세요.";
		}
		ckloginMap.put("msg", msg);
		ckloginMap.put("url", url);
		
		return ckloginMap;
	}

	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		session.removeAttribute("customer");
		session.removeAttribute("action");
		mav.setViewName("redirect:/main.do");
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "/addCustomer.do", method = RequestMethod.POST)
	public Map<String, String> addCustomer(@ModelAttribute("customerVO") CustomerVO customerVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println(customerVO);
		Map<String, String> joinMap = new HashMap<String, String>();
		String msg = null;
		String url = null;
		try {
			customerService.addCustomer(customerVO);
			msg = "회원가입 완료";
			url = request.getContextPath() + "/form/loginForm.do";
		} catch (Exception e) {
			msg = "이미 존재하는 회원입니다.";
			e.printStackTrace();
		}
		joinMap.put("msg", msg);
		joinMap.put("url", url);
		
		return joinMap;
	}

}