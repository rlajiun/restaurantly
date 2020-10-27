package com.restaurantly.review.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.restaurantly.review.dto.ReviewDTO;

public interface ReviewController {

	ModelAndView listReview(String restaurant_license, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	ModelAndView addReview(String restaurant_license, ReviewDTO reviewDTO, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	ModelAndView reviewForm(String restaurant_license, ReviewDTO reviewDTO, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	ModelAndView modReview(String review_id, HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView removeReview(String review_id, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

}