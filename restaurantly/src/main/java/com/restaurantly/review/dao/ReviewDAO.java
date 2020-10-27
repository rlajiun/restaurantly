package com.restaurantly.review.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.restaurantly.review.dto.ReviewDTO;

public interface ReviewDAO {

	public List<ReviewDTO> selectReviewList(String restaurant_license) throws DataAccessException;

	public void updateReview(Map reviewMap) throws DataAccessException;

	public void deleteReview(String review_id) throws DataAccessException;

	public String selectNewReviewID() throws DataAccessException;

	public String insertNewReview(Map reviewMap);

	public float calScore(String restaurant_license) throws DataAccessException;


}