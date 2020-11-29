package com.restaurantly.review.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import com.restaurantly.review.vo.ReviewImageVO;
import com.restaurantly.review.vo.ReviewVO;

public interface ReviewService {

	public List<ReviewVO> listReview(String restaurant_license) throws Exception;

	public void addReview(MultipartRequest multipartRequest, ReviewVO reviewVO) throws Exception;

	public void modReview(ReviewVO reviewVO) throws Exception;

	/*
	 * public void removeReview(String review_id);
	 */
	public void calScore(String review_id);

	public List<ReviewVO> listMyReview(String customer_id) throws Exception;

	public void removeReview(String review_id) throws Exception;

	
}