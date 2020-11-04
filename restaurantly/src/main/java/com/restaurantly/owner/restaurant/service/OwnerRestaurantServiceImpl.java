package com.restaurantly.owner.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurantly.owner.restaurant.dao.OwnerRestaurantDAO;
import com.restaurantly.restaurant.vo.RestaurantVO;

@Service("ownerRestaurantService")
public class OwnerRestaurantServiceImpl implements OwnerRestaurantService {
	@Autowired
	private OwnerRestaurantDAO ownerRestaurantDAO;

	@Override
	public RestaurantVO restaurantInfo(String owner_id) throws Exception {
		RestaurantVO restaurant = ownerRestaurantDAO.selectRestaurant(owner_id);
		return restaurant;
	}

	@Override
	public void addRestaurant(RestaurantVO restaurantVO) throws Exception {
		ownerRestaurantDAO.insertRestaurant(restaurantVO);
	}

}
