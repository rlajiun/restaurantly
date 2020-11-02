package com.restaurantly.review.service;

import java.util.List;
import java.util.Map;

import com.restaurantly.review.vo.ReviewVO;

public interface ReviewService {

	public List<ReviewVO> listReview(String restaurant_license) throws Exception;

	public String addNewReview(Map reviewMap);

	public void modReview(Map reviewMap);

	public void removeReview(String review_id);

	public void calScore(String review_id);

}