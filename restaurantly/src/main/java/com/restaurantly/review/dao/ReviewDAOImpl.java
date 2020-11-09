package com.restaurantly.review.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.restaurantly.review.vo.ReviewImageVO;
import com.restaurantly.review.vo.ReviewVO;

@Repository("reviewDAO")
public class ReviewDAOImpl implements ReviewDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<ReviewVO> selectReviewList(String restaurant_license) throws DataAccessException{
		System.out.println("DAO: selectReviewList:" +restaurant_license);
		List<ReviewVO> reviewList = (List)sqlSession.selectList("mapper.review.selectReviewList", restaurant_license);
		return reviewList;
	}
	@Override
	public List<ReviewVO> selectMyReviewList(String customer_id) throws DataAccessException{
		System.out.println("DAO: My ReviewList:"+customer_id);
		List<ReviewVO> reviewList = (List)sqlSession.selectList("mapper.review.selectMyReviewList", customer_id);
		return reviewList;
	}
	
	@Override
	public void insertReview(ReviewVO reviewVO) throws DataAccessException{
		System.out.println("DAO: insert review");
		sqlSession.insert("mapper.review.insertReview", reviewVO);
	}

	@Override
	public void updateReview(ReviewVO reviewVO) throws DataAccessException{
		sqlSession.update("mapper.review.updateReview", reviewVO);
	
	}

	@Override
	public void deleteReview(String review_id) throws DataAccessException{
		sqlSession.delete("mapper.review.deleteReview", review_id);
	
	}


	@Override
	public String selectNewReviewID() throws DataAccessException {
		return sqlSession.selectOne("mapper.review.selectNewReviewID");
		
	}

	@Override
	public float calScore(String restaurant_license) throws DataAccessException {
		return sqlSession.selectOne("mapper.review.calculateScore", restaurant_license);
		
	}
	@Override
	public void insertReviewImg(ReviewImageVO reviewImageVO) {
		sqlSession.insert("mapper.review.insertReviewImg", reviewImageVO);
	
		
	}
	@Override
	public void deleteReviewImg(String review_id) {
		sqlSession.delete("mapper.review.deleteReviewImg", review_id);
		
	}

	
	
	




}
