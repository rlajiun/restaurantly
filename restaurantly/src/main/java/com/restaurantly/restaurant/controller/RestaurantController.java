package com.restaurantly.restaurant.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface RestaurantController {
	// 식당 종목(한식, 일식, 중식, 양식 등)에 따라 식당 리스트 출력
	public ModelAndView listRestaurant(@RequestParam("restaurant_item") String restaurant_item, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// 랜덤 음식 선택되었을때 나온 음식이 있는 모든 식당 리스트 출력
	public ModelAndView listRandomRestaurant(@RequestParam("menu_category") String menu_category, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// 리스트에서 식당 선택되었을 때 선택된 식당에 대한 정보 출력	
	public ModelAndView restaurantInfo(@RequestParam("restaurant_license") String restaurant_license, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
