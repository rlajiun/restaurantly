package com.restaurantly.review.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.STRING;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.restaurantly.review.dao.ReviewDAO;
import com.restaurantly.review.dto.ReviewDTO;

@Service("reviewService")
@Transactional(propagation=Propagation.REQUIRED)

public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	ReviewDAO reviewDAO;
	

	@Override
	public List<ReviewDTO> listReview(String restaurant_license) throws Exception{
		List<ReviewDTO> menuList = reviewDAO.selectReviewList(restaurant_license);
		return menuList;
	}


	@Override
	public String addNewReview(Map reviewMap) {
		// TODO Auto-generated method stub
		//다중이미지
		/*
		 * String review_id = reviewDAO.insertNewReview(reviewMap);
		 * reviewMap.put("review_id", review_id); reviewDAO.insertNewImage(reviewMap);
		 * return review_id;
		 */
		String review_id = (String) reviewMap.get("review_id");
		reviewDAO.calScore(review_id);
		return reviewDAO.insertNewReview(reviewMap);
	}


	@Override
	public void modReview(Map reviewMap) {
		// TODO Auto-generated method stub
		String review_id = (String) reviewMap.get("review_id");
		reviewDAO.updateReview(reviewMap);
		
	}


	@Override
	public void removeReview(String review_id) {
		// TODO Auto-generated method stub
		reviewDAO.deleteReview(review_id);
	}
	
	public void calScore(String restaurant_license) {
		reviewDAO.calScore(restaurant_license);
	}


	
}
