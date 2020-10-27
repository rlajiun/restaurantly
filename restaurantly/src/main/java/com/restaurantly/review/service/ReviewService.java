package com.restaurantly.review.service;

import java.util.List;

import com.restaurantly.review.dto.ReviewDTO;

public interface ReviewService {

	List<ReviewDTO> listReview(String restaurant_license) throws Exception;

	ReviewDTO addReview(ReviewDTO reviewDTO);

	void modReview(ReviewDTO reviewDTO);

	void removeReview(String review_id);

}