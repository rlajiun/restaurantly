package com.restaurantly.customer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.restaurantly.customer.vo.CustomerVO;

//리스트 멤버추가 멤버수정 멤버삭제 맞는지 모르겠음

public interface CustomerController {
	
	public ModelAndView addmember(@ModelAttribute("CustomerVO") CustomerVO customer,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView modmember(@ModelAttribute("CustomerVO") CustomerVO customer,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView deletemember(@ModelAttribute("CustomerVO") CustomerVO customer,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
}
