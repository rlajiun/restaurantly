package com.restaurantly.restaurant.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.restaurantly.restaurant.dto.RestaurantDTO;

public interface RestaurantDAO {
	// 식당 종목(한식, 일식, 중식, 양식 등)에 따라 식당 리스트 출력
	public List<RestaurantDTO> selectRestaurantList(String restaurant_item) throws DataAccessException;
	
	// 랜덤 음식 선택되었을때 나온 음식이 있는 모든 식당 리스트 출력
	public List<RestaurantDTO> selectRandomRestaurantList(String menu_category) throws DataAccessException;
	
	// 리스트에서 식당 선택되었을 때 선택된 식당에 대한 정보 출력
	public RestaurantDTO selectRestaurant(String restaurant_license) throws DataAccessException;
}
