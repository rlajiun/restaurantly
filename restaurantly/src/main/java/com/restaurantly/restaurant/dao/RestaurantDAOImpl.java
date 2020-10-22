package com.restaurantly.restaurant.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.restaurantly.restaurant.dto.RestaurantDTO;

@Repository("restaurantDAO")
public class RestaurantDAOImpl implements RestaurantDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<RestaurantDTO> selectRestaurantList(String restaurant_item) throws DataAccessException {
		List<RestaurantDTO> restaurantList = (List)sqlSession.selectList("mapper.mypage.selectMyOrderGoodsList",member_id);
		return restaurantList;
	}

	@Override
	public List<RestaurantDTO> selectRandomRestaurantList(String menu_category) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestaurantDTO selectRestaurant(String restaurant_license) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
