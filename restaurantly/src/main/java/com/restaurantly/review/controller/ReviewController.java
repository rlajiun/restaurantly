package com.restaurantly.review.controller;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.STRING;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;


import com.restaurantly.restaurant.service.RestaurantService;
import com.restaurantly.restaurant.vo.RestaurantVO;
import com.restaurantly.review.service.ReviewService;
import com.restaurantly.review.vo.ReviewImageVO;
import com.restaurantly.review.vo.ReviewVO;

@Controller("reviewController")
@RequestMapping(value = "/review")
public class ReviewController {
	private static final String REVIEW_IMAGE_REPO  = "C:\\restaurantly\\file_repo";
	
	@Autowired
	private ReviewVO reviewVO;
	@Autowired
	private ReviewService reviewService;
	
	// 특정 식당의 리뷰 리스트
	@RequestMapping(value = "/reviewList.do", method = RequestMethod.GET)
	public String listReview(@RequestParam("restaurant_license") String restaurant_license, Model model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = "reviewList";	
		List<ReviewVO> reviewList = reviewService.listReview(restaurant_license);
		model.addAttribute("reviewList", reviewList);
		return viewName;
	}
	// 사용자의 리뷰 리스트 "마이리뷰"
	@RequestMapping(value = "/myReviewList.do", method = RequestMethod.GET)
	public String myReviewList(
			@RequestParam("customer_id") String customer_id, Model model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CONTROLLER - MY REVIEW LIST " + customer_id);
		String viewName = "myReviewList";
		List<ReviewVO> reviewList = reviewService.listMyReview(customer_id);
		model.addAttribute("reviewList", reviewList);
		String url = "/review/myReviewList";
		
		return url;
	}
	@RequestMapping(value = "/addReview.do", method = RequestMethod.POST)
	public String addReview(
			@ModelAttribute("reviewVO") ReviewVO reviewVO, MultipartHttpServletRequest multipartRequest,  
			HttpServletRequest request, HttpServletResponse response)  throws Exception{ 
		multipartRequest.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String msg, url;
		
		try {
			reviewService.addReview(multipartRequest, reviewVO);
			System.out.println("CONTROLLER addreview" +reviewVO);
			msg = reviewVO.getReview_id() + " 등록 되었습니다.";
			url = "/review/myReviewList";
		} catch (Exception e) {
			msg = "등록에 실패했습니다. 정보를 확인해주세요.";
			url = "/review/reviewForm";
			e.printStackTrace();
		}
		//model.addAttribute("msg", msg);
		System.out.println(msg);
		System.out.println(url);
		return url;
	}
	@RequestMapping(value = "/modReviewForm.do", method = RequestMethod.GET)
	public String modReviewForm( Model model, @RequestParam("reviewVO") ReviewVO reviewVO,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = "/review/modReviewForm";
		model.addAttribute("existing", reviewVO);
		
	
		return viewName;
	}
	
	@RequestMapping(value = "/modReview.do", method = RequestMethod.GET)
	public String modReview( Model model, @ModelAttribute("reviewVO") ReviewVO reviewVO, MultipartHttpServletRequest multipartRequest,  
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String msg, url = null;
		
		try {
			reviewService.modReview(reviewVO);
			System.out.println(reviewVO);
			msg = reviewVO.getReview_id() + " 수정되었습니다.";
			url = "/review/myReviewList";
		} catch (Exception e) {
			msg = "실패했습니다. 정보를 확인해주세요.";
			url = "/review/modReview";
			e.printStackTrace();
		}
		//model.addAttribute("msg", msg);
		return url;
	}

	
	@RequestMapping(value = "/removeReview.do", method = RequestMethod.GET)
	public String removeReview(@ModelAttribute("ReviewVO") ReviewVO reviewVO, 
			Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		String msg, url;
		try {
			reviewService.removeReview(reviewVO);
			String review_id = reviewVO.getReview_id();
			reviewService.calScore(review_id);
			msg = "리뷰를 삭제했습니다";
		} catch (Exception e) {
			msg = "오류 발생. 실패했습니다. 다시 시도하십시오.";
			e.printStackTrace();
		}
		model.addAttribute("msg", msg);
		url = "/review/myReviewList";
		return url;
	}

}
