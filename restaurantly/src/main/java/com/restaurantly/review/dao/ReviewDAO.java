package com.restaurantly.review.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.restaurantly.review.dto.ReviewDTO;

public interface ReviewDAO {

	List<String> selectReviewCategory() throws DataAccessException;

	List<ReviewDTO> selectReviewList(String restaurant_license) throws DataAccessException;

	String insertReview(ReviewDTO reviewDTO) throws DataAccessException;

	ReviewDTO updateReview(ReviewDTO reviewDTO) throws DataAccessException;

	ReviewDTO deleteReview(ReviewDTO reviewDTO) throws DataAccessException;

}