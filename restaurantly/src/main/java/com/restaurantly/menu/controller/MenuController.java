package com.restaurantly.menu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface MenuController {
	public ModelAndView listRandomMenu(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
