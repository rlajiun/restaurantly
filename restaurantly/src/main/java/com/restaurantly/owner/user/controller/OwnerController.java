package com.restaurantly.owner.user.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.restaurantly.owner.user.vo.OwnerVO;

public interface OwnerController {
	public ModelAndView login(@RequestParam Map<String, String> loginMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ResponseEntity addOwner(@ModelAttribute("owner") OwnerVO ownerVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	public ResponseEntity overlapped(@RequestParam("owner_id") String owner_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception;
}
