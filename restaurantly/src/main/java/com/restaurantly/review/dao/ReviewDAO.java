package com.restaurantly.review.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.restaurantly.review.dto.ReviewDTO;

public interface ReviewDAO {

	List<ReviewDTO> selectReviewList(String restaurant_license) throws DataAccessException;

	void updateReview(Map reviewMap) throws DataAccessException;

	void deleteReview(String review_id) throws DataAccessException;

	String selectNewReviewID() throws DataAccessException;

	String insertNewReview(Map reviewMap);

	void calScore(String review_id) throws DataAccessException;


}