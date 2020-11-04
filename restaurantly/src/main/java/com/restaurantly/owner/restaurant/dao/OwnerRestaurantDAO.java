package com.restaurantly.owner.restaurant.dao;

import org.springframework.dao.DataAccessException;

import com.restaurantly.restaurant.vo.RestaurantVO;

public interface OwnerRestaurantDAO {

	public RestaurantVO selectRestaurant(String owner_id) throws DataAccessException;

	public void insertRestaurant(RestaurantVO restaurantVO) throws DataAccessException;
	
}
