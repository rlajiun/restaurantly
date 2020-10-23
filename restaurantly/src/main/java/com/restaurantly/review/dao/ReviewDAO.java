package com.restaurantly.review.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.restaurantly.review.dto.ReviewDTO;

public interface ReviewDAO {
	/*
	 * 리뷰 리스트 출력 리뷰 등록 리뷰 수정 리뷰 삭제
	 */

	public List<ReviewDTO> selectReviewList(String restaurant_license) throws DataAccessException;
	public ReviewDTO addReview(String restaurant_license) throws DataAccessException;
	public ReviewDTO modReview(String review_id) throws DataAccessException;
	public ReviewDTO deleteReview(String review_id) throws DataAccessException;
}
