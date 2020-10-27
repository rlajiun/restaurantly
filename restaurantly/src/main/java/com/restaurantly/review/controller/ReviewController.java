package com.restaurantly.review.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.restaurantly.review.dto.ReviewDTO;

public interface ReviewController {

	ModelAndView listReview(String restaurant_license, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	public ResponseEntity addNewReview(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception;

	
	public ModelAndView reviewForm(HttpServletRequest request, HttpServletResponse response) throws Exception;

	ResponseEntity modReview(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception;
	
	public ResponseEntity removeReview(String review_id, HttpServletRequest request, HttpServletResponse response)
			throws Exception;



}