package com.restaurantly.review.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.STRING;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import com.restaurantly.common.base.BaseService;
import com.restaurantly.restaurant.vo.RestaurantVO;
import com.restaurantly.common.base.ImageVO;
import com.restaurantly.review.dao.ReviewDAO;
import com.restaurantly.review.vo.ReviewImageVO;
import com.restaurantly.review.vo.ReviewVO;

@Service("reviewService")
@Transactional(propagation=Propagation.REQUIRED)

public class ReviewServiceImpl extends BaseService implements ReviewService {
	private static final String CURR_IMAGE_REPO_PATH = "C:\\restaurantly\\file_repo";
	
	@Autowired
	ReviewDAO reviewDAO;
	

	@Override
	public List<ReviewVO> listReview(String restaurant_license) throws Exception{
		List<ReviewVO> reviewList = reviewDAO.selectReviewList(restaurant_license);
		return reviewList;
	}

//	@Override
//	public void addReview(ReviewVO reviewVO, MultipartFile file) throws Exception {
//		String fileName = uploadOne(file);
//		System.out.println("**filename");
//		
//		try {
//			String review_id=reviewDAO.selectNewReviewID(); // 글번호+1함
//			reviewVO.setReview_id(review_id);
//			reviewVO.setReview_image_path(fileName);
//			reviewDAO.insertReview(reviewVO);
//			if (fileName != null) {
//				File srcFile = new File(CURR_IMAGE_REPO_PATH + "\\" + "temp" + "\\" + fileName);
//				File destDir = new File(CURR_IMAGE_REPO_PATH + "\\" + reviewVO.getRestaurant_license());
//				FileUtils.moveFileToDirectory(srcFile, destDir, true);
//			}
//		} catch (Exception e) {
//			if (fileName != null) {
//				File srcFile = new File(CURR_IMAGE_REPO_PATH + "\\" + "temp" + "\\" + fileName);
//				srcFile.delete();
//			}
//			e.printStackTrace();
//		}
//	}
	// multiple images
	@Override
	public void addReview(MultipartRequest multipartRequest, ReviewVO reviewVO) throws Exception {
		System.out.println("service: addReivew - upload files");
		List<MultipartFile> files = multipartRequest.getFiles("images");
		System.out.println("images");
		// 파일 업로드
		uploadFiles(files);
		// 내용 db에 저장
		System.out.println("service: addReivew - insert review");
		
		String review_id=reviewDAO.selectNewReviewID(); // 글번호+1함
		reviewVO.setReview_id(review_id);
		//reviewVO.setReview_image_path(fileName);
		reviewDAO.insertReview(reviewVO);
		return;
	}
	
	@Override
	public void modReview(ReviewVO reviewVO, MultipartFile file) throws Exception {
		String fileName = uploadOne(file);
		try {
			reviewVO.setReview_image_path(fileName);
			reviewDAO.updateReview(reviewVO);
			if (fileName != null) {
				File srcFile = new File(CURR_IMAGE_REPO_PATH + "\\" + "temp" + "\\" + fileName);
				File destDir = new File(CURR_IMAGE_REPO_PATH + "\\" + reviewVO.getRestaurant_license());
				FileUtils.moveFileToDirectory(srcFile, destDir, true);
			}
		} catch (Exception e) {
			if (fileName != null) {
				File srcFile = new File(CURR_IMAGE_REPO_PATH + "\\" + "temp" + "\\" + fileName);
				srcFile.delete();
			}
			e.printStackTrace();
		}
	}
		
	@Override
	public void removeReview(String review_id) {
		reviewDAO.deleteReview(review_id);
	}
	
	@Override
	public void calScore(String restaurant_license) {
		reviewDAO.calScore(restaurant_license);
	}

	


	
}
