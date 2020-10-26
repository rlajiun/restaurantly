package com.restaurantly.restaurant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	@RequestMapping(value = "/restaurantList.do", method = RequestMethod.GET)
	public ModelAndView listRestaurant(@RequestParam("item") String restaurant_item, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		List<RestaurantVO> restaurantList;
		if (restaurant_item.equals("all")) {
			restaurantList = restaurantService.listRestaurant();
		} else {
			restaurantList = restaurantService.listRestaurant(restaurant_item);
		}
		mav.addObject("restaurantList", restaurantList);

		return mav;
	}

	@Override
	@RequestMapping(value = "/restaurantList.do", method = RequestMethod.POST)
	public ModelAndView listRandomRestaurant(@RequestParam("menu_category") String menu_category, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		List<RestaurantVO> restaurantList = restaurantService.listRandomRestaurant(menu_category);
		mav.addObject("restaurantList", restaurantList);

		return mav;
	}

	@Override
	@RequestMapping(value = "/restaurantMain/{restaurant_license}", method = RequestMethod.GET)
	public ModelAndView restaurantInfo(@PathVariable("restaurant_license") String restaurant_license, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
