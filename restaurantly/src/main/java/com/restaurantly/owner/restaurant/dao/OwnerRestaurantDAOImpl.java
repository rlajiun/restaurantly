package com.restaurantly.owner.restaurant.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.restaurantly.restaurant.vo.MenuVO;
import com.restaurantly.restaurant.vo.RestaurantVO;

@Repository("ownerRestaurantDAO")
public class OwnerRestaurantDAOImpl implements OwnerRestaurantDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public RestaurantVO selectRestaurant(String owner_id) throws DataAccessException {
		RestaurantVO restaurant = (RestaurantVO)sqlSession.selectOne("mapper.owner.restaurant.selectRestaurant", owner_id);
		return restaurant;
	}

	@Override
	public void insertRestaurant(RestaurantVO restaurantVO) throws DataAccessException {
		sqlSession.insert("mapper.owner.restaurant.insertRestaurant", restaurantVO);
	}

	@Override
	public List<MenuVO> selectMenuList(String restaurant_license) throws DataAccessException {
		List<MenuVO> menuList = (List)sqlSession.selectList("mapper.owner.restaurant.selectMenuList", restaurant_license);
		return menuList;
	}
	
	
}
