package com.restaurantly.customer.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.restaurantly.common.base.BaseController;
import com.restaurantly.customer.service.CustomerService;
import com.restaurantly.customer.vo.CustomerVO;

//리스트 멤버추가 멤버수정 멤버삭제 맞는지 모르겠음

@Controller("customerController")
@RequestMapping(value = "/customer")
public class CustomerControllerImpl extends BaseController implements CustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	CustomerVO customerVO;

	@Override
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam Map<String, String> loginMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		customerVO = customerService.login(loginMap);
		if (customerVO != null && customerVO.getCustomer_id() != null) {
			HttpSession session = request.getSession();
			session = request.getSession();
			session.setAttribute("customer", customerVO);
			String action = (String) session.getAttribute("action");
			if (action != null && action.equals("/booking/bookList.do")) {
				mav.setViewName("forward:" + action);
			} else {
				mav.setViewName("redirect:/main/main.do");
			}

		} else {
			String message = "아이디 또는 비밀번호를 확인해주세요!";
			mav.addObject("message", message);
			mav.setViewName("/form/loginForm");
		}
		return mav;
	}

	@Override
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		session.removeAttribute("customer");
		mav.setViewName("redirect:/main/main.do");
		return mav;
	}

	@Override
	@RequestMapping(value = "/addCustomer.do", method = RequestMethod.POST)
	public ResponseEntity addCustomer(@ModelAttribute("customerVO") CustomerVO customerVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			customerService.addCustomer(customerVO);
			message = "<script>";
			message += " alert('회원가입 완료!');";
			message += " location.href='" + request.getContextPath() + "/form/loginForm.do';";
			message += " </script>";

		} catch (Exception e) {
			message = "<script>";
			message += " alert('이미 존재하는 회원입니다.');";
			message += " location.href='" + request.getContextPath() + "/joinForm.do';";
			message += " </script>";
			e.printStackTrace();
		}
		resEntity = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}

}