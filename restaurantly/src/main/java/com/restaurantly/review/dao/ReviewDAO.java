package com.restaurantly.review.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.restaurantly.review.vo.ReviewImageVO;
import com.restaurantly.review.vo.ReviewVO;

public interface ReviewDAO {

	public List<ReviewVO> selectReviewList(String restaurant_license) throws DataAccessException;

	public void insertReview(ReviewVO reviewVO) throws DataAccessException;

	public void updateReview(ReviewVO reviewVO) throws DataAccessException;

	public void deleteReview(String review_id) throws DataAccessException;

	public String selectNewReviewID() throws DataAccessException;

	public float calScore(String restaurant_license) throws DataAccessException;

	public List<ReviewVO> selectMyReviewList(String customer_id) throws DataAccessException;

	public void insertReviewImg(ReviewImageVO reviewImageVO) throws DataAccessException;

	public List<ReviewImageVO> selectPhotoList(String review_id) throws DataAccessException;

	public void deletePhotoList(String review_id) throws DataAccessException; 

	
}