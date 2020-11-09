package com.restaurantly.owner.restaurant.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.restaurantly.restaurant.vo.MenuVO;
import com.restaurantly.restaurant.vo.RestaurantImageVO;
import com.restaurantly.restaurant.vo.RestaurantVO;

public interface OwnerRestaurantDAO {

	public RestaurantVO selectRestaurant(String owner_id) throws DataAccessException;

	public void insertRestaurant(RestaurantVO restaurantVO) throws DataAccessException;

	public List<MenuVO> selectMenuList(String restaurant_license) throws DataAccessException;

	public void updateRestaurant(RestaurantVO restaurantVO) throws DataAccessException;

	public List<RestaurantImageVO> selectPhotoList(String restaurant_license) throws DataAccessException;

	public void insertMenu(List<MenuVO> menuList) throws DataAccessException;

	public List<String> selectCategory() throws DataAccessException;

	public void updateMenu(List<MenuVO> menuList) throws DataAccessException;

	public void deleteMenu(String menu_id) throws DataAccessException;
	
}
