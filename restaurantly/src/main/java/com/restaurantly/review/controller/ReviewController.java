package com.restaurantly.review.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface ReviewController {
	/*
	 * 리뷰 리스트 출력 /리뷰 등록 /리뷰 수정/ 리뷰 삭제
	 */

	public ModelAndView listReview(@RequestParam("restaurant_license") String restaurant_item,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addReview(@RequestParam("restaurant_license") String menu_category,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView modReview(@RequestParam("review_id") String menu_category,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView deleteReview(@RequestParam("review_id") String menu_category,
			HttpServletRequest request, HttpServletResponse response) throws Exception;

	

}
