package com.restaurantly.review.controller;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
	

	
	@RequestMapping(value = "/reviewList.do", method = RequestMethod.GET)
	public String listReview(@RequestParam("restaurant_license") String restaurant_license, Model model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = "reviewList";
		List<ReviewVO> reviewList = reviewService.listReview(restaurant_license);
		model.addAttribute("reviewList", reviewList);
		return viewName;
	}
	 
//	@RequestMapping(value = "/addReview.do", method = RequestMethod.POST)
//	public String addReview(Model model, @RequestParam("file") MultipartFile file, 
//			HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		String msg, url;
//		System.out.println("**addReview");
//		try {
//			reviewService.addReview(reviewVO, file);
//			System.out.println(reviewVO);
//			msg = reviewVO.getReview_id() + " 등록 되었습니다.";
//			url = request.getContextPath() + "/restaurant/restaurantMain.do?restaurant_license="+reviewVO.getRestaurant_license();
//		} catch (Exception e) {
//			msg = "등록에 실패했습니다. 정보를 확인해주세요.";
//			url = request.getContextPath() + "/restaurant/restaurantMain.do?restaurant_license="+reviewVO.getRestaurant_license();
//			e.printStackTrace();
//		}
//		model.addAttribute("msg", msg);
//		System.out.println(msg);
//		System.out.println(url);
//		return url;
//	}
	@RequestMapping(value = "/addReview.do", method = RequestMethod.POST)
	public String addReview(
			@ModelAttribute("reviewVO") ReviewVO reviewVO, MultipartHttpServletRequest multipartRequest,  
			HttpServletRequest request, HttpServletResponse response)  throws Exception{ 
		String viewName = request.getContextPath() + "/restaurant/restaurantMain.do";
		System.out.println("**addreview2 - multiple img");
		multipartRequest.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String msg, url;
		System.out.println("**addReview");
		
		//List<MultipartFile> files = multipartRequest.getFiles("mFile");
		
		try {
			reviewService.addReview(multipartRequest, reviewVO);
			
			System.out.println(reviewVO);
			msg = reviewVO.getReview_id() + " 등록 되었습니다.";
			url = request.getContextPath() + "/main/main.do";
		} catch (Exception e) {
			msg = "등록에 실패했습니다. 정보를 확인해주세요.";
			url = request.getContextPath() + "/main/main.do";
			e.printStackTrace();
		}
		//model.addAttribute("msg", msg);
		System.out.println(msg);
		System.out.println(url);
		
		return viewName;
	}
	
	@RequestMapping(value = "/modReview.do", method = RequestMethod.GET)
	public String modReview(Model model, @RequestParam("file") MultipartFile file, 
			 HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String msg, url = null;
		try {
			reviewService.modReview(reviewVO, file);
			System.out.println(reviewVO);
			msg = reviewVO.getReview_id() + " 수정되었습니다.";
			url = request.getContextPath() + "/restaurant/restaurantMain.do?restaurant_license="+reviewVO.getRestaurant_license();
		} catch (Exception e) {
			msg = "실패했습니다. 정보를 확인해주세요.";
			url = request.getContextPath() + "/restaurant/restaurantMain.do?restaurant_license="+reviewVO.getRestaurant_license();
			e.printStackTrace();
		}
		model.addAttribute("msg", msg);
		return url;
	}

	
	@RequestMapping(value = "/removeReview.do", method = RequestMethod.GET)
	public String removeReview(@ModelAttribute("ReviewVO") ReviewVO reviewVO, @RequestParam("review_id") String review_id, 
			Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		String msg, url;
		try {
			reviewService.removeReview(review_id);
			reviewService.calScore(review_id);
			File destDir = new File(REVIEW_IMAGE_REPO + "\\" + review_id);
			FileUtils.deleteDirectory(destDir);
			msg = "리뷰를 삭제했습니다";
		} catch (Exception e) {
			msg = "오류 발생. 실패했습니다. 다시 시도하십시오.";
			e.printStackTrace();
		}
		model.addAttribute("msg", msg);
		url = request.getContextPath() + "/restaurant/restaurantMain.do?restaurant_license=" +reviewVO.getRestaurant_license();
		return url;
	}

}
