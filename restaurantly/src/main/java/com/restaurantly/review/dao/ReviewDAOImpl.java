package com.restaurantly.review.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.restaurantly.menu.vo.MenuVO;
import com.restaurantly.restaurant.vo.RestaurantVO;
import com.restaurantly.review.dto.ReviewDTO;
@Repository("reviewDAO")
public class ReviewDAOImpl implements ReviewDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<ReviewDTO> selectReviewList(String restaurant_license) throws DataAccessException{
		List<ReviewDTO> reviewList = (List)sqlSession.selectList("mapper.review.selectReviewList ", restaurant_license);
		return reviewList ;
	}

	@Override
	public String insertNewReview(Map reviewMap) throws DataAccessException{
		
		sqlSession.insert("mapper.review.insertReview", reviewMap);
		// String review_id = Integer.toString(selectNewReviewID()); // type casting
		String review_id=selectNewReviewID();
		reviewMap.put("review_id", review_id);
		return review_id;
		
		
	}

	@Override
	public void updateReview(Map reviewMap) throws DataAccessException{
		sqlSession.insert("mapper.review.updateReview", reviewMap);
	
	}

	@Override
	public void deleteReview(String review_id) throws DataAccessException{
		sqlSession.selectOne("mapper.review.deleteReview", review_id);
	
	}


	@Override
	public String selectNewReviewID() throws DataAccessException {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.review.selectNewReviewID");
		
	}

	@Override
	public float calScore(String restaurant_license) throws DataAccessException {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.review.calculateScore", restaurant_license);
		
	}

	
	
	




}
