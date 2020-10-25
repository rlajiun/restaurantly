package com.restaurantly.restaurant.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface RestaurantController {
	public ModelAndView listRestaurant(@RequestParam("restaurant_item") String restaurant_item, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView listRandomRestaurant(@RequestParam("menu_category") String menu_category, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView restaurantInfo(@RequestParam("restaurant_license") String restaurant_license, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
