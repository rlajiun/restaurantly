package com.restaurantly.restaurant.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.restaurantly.restaurant.vo.MenuVO;
import com.restaurantly.restaurant.vo.RestaurantVO;

public interface RestaurantDAO {
	public List<RestaurantVO> selectRestaurantList() throws DataAccessException;
	
	public List<RestaurantVO> selectRestaurantList(String restaurant_item) throws DataAccessException;
	
	public List<RestaurantVO> selectRandomRestaurantList(String menu_category) throws DataAccessException;
	
	public RestaurantVO selectRestaurant(String restaurant_license) throws DataAccessException;

	public List<MenuVO> selectMenuList(String restaurant_license) throws DataAccessException;

	public List<String> selectMenuCategory() throws DataAccessException;

	public List<MenuVO> selectMenuListForCat(String menu_category) throws DataAccessException;

}
