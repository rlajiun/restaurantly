package com.restaurantly.restaurant.service;

import java.util.List;

import com.restaurantly.restaurant.vo.RestaurantVO;

public interface RestaurantService {
	// 식당 종목(한식, 일식, 중식, 양식 등)에 따라 식당 리스트 출력
	public List<RestaurantVO> listRestaurant(String restaurant_item) throws Exception;

	// 랜덤 음식 선택되었을때 나온 음식이 있는 모든 식당 리스트 출력
	public List<RestaurantVO> listRandomRestaurant(String menu_category) throws Exception;

	// 리스트에서 식당 선택되었을 때 선택된 식당에 대한 정보 출력
	public RestaurantVO restaurantInfo(String restaurant_license) throws Exception;
}