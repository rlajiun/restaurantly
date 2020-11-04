package com.restaurantly.owner.restaurant.service;

import com.restaurantly.restaurant.vo.RestaurantVO;

public interface OwnerRestaurantService {

	public RestaurantVO restaurantInfo(String owner_id) throws Exception;

	public void addRestaurant(RestaurantVO restaurantVO) throws Exception;

}
