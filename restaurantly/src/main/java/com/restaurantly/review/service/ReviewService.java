package com.restaurantly.review.service;

import java.util.List;
import java.util.Map;

import com.restaurantly.review.vo.ReviewVO;

public interface ReviewService {

	List<ReviewVO> listReview(String restaurant_license) throws Exception;

	String addNewReview(Map reviewMap);

	void modReview(Map reviewMap);

	void removeReview(String review_id);

	public void calScore(String review_id);

}