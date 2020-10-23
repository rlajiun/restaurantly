package com.restaurantly.review.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.restaurantly.review.dto.ReviewDTO;

public class ReviewDAOImpl implements ReviewDAO{

	@Override
	public List<ReviewDTO> selectReviewList(String restaurant_license) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReviewDTO addReview(String restaurant_license) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public ReviewDTO modReview(String review_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReviewDTO deleteReview(String review_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
