package com.restaurantly.customer.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

import com.restaurantly.customer.vo.CustomerVO;

//리스트 멤버추가 멤버수정 멤버삭제 맞는지 모르겠음

public interface CustomerController {

	public ModelAndView login(Map<String, String> loginMap, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ResponseEntity addCustomer(CustomerVO customerVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception;
}