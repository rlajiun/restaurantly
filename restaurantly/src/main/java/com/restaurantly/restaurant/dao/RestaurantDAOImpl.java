package com.restaurantly.restaurant.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.restaurantly.restaurant.vo.MenuVO;
import com.restaurantly.restaurant.vo.RestaurantVO;

@Repository("restaurantDAO")
public class RestaurantDAOImpl implements RestaurantDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<RestaurantVO> selectRestaurantList() throws DataAccessException {
		List<RestaurantVO> restaurantList = (List)sqlSession.selectList("mapper.restaurant.selectAllRestaurantList");
		return restaurantList;
	}

	@Override
	public List<RestaurantVO> selectRestaurantList(String restaurant_item) throws DataAccessException {
		List<RestaurantVO> restaurantList = (List)sqlSession.selectList("mapper.restaurant.selectRestaurantList", restaurant_item);
		return restaurantList;
	}

	@Override
	public List<RestaurantVO> selectRandomRestaurantList(String menu_category) throws DataAccessException {
		List<RestaurantVO> restaurantList = (List)sqlSession.selectList("mapper.restaurant.selectRandomRestaurantList", menu_category);
		return restaurantList;
	}

	@Override
	public RestaurantVO selectRestaurant(String restaurant_license) throws DataAccessException {
		RestaurantVO restaurant = (RestaurantVO)sqlSession.selectOne("mapper.restaurant.selectRestaurant", restaurant_license);
		return restaurant;
	}

	@Override
	public List<MenuVO> selectMenuList(String restaurant_license) throws DataAccessException {
		List<MenuVO> menuList = (List)sqlSession.selectList("mapper.restaurant.selectMenuList", restaurant_license);
		return menuList;
	}

	@Override
	public List<String> selectMenuCategory() throws DataAccessException {
		List<String> menuCatList = (List)sqlSession.selectList("mapper.restaurant.selectMenuCategory");
		return menuCatList;
	}

	@Override
	public List<MenuVO> selectMenuListForCat(String menu_category) throws DataAccessException {
		List<MenuVO> menuList = (List)sqlSession.selectList("mapper.restaurant.selectMenuListCat", menu_category);
		return menuList;
	}

}
