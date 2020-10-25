package com.restaurantly.restaurant.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.restaurantly.restaurant.service.RestaurantService;
import com.restaurantly.restaurant.vo.RestaurantVO;

@Controller("restaurantController")
@RequestMapping(value = "/restaurant")
public class RestaurantControllerImpl implements RestaurantController {
	@Autowired
	private RestaurantVO restaurantVO;
	@Autowired
	private RestaurantService restaurantService;

	@Override
	public ModelAndView listRestaurant(String restaurant_item, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView listRandomRestaurant(String menu_category, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView restaurantInfo(String restaurant_license, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
