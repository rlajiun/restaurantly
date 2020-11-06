package com.restaurantly.owner.restaurant.service;

import org.springframework.web.multipart.MultipartFile;

import com.restaurantly.restaurant.vo.RestaurantVO;

public interface OwnerRestaurantService {

	public RestaurantVO restaurantInfo(String owner_id) throws Exception;

	public void addRestaurant(RestaurantVO restaurantVO, MultipartFile file) throws Exception;

	public void editRestaurant(RestaurantVO restaurantVO, MultipartFile file) throws Exception;

}
