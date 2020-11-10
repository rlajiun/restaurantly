package com.restaurantly.review.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import com.restaurantly.common.base.BaseService;
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
		System.out.println("SERVICE: ReviewList:"+restaurant_license);
		List<ReviewVO> reviewList = reviewDAO.selectReviewList(restaurant_license);
		return reviewList;
	}
	@Override
	public List<ReviewVO> listMyReview(String customer_id) throws Exception{
		System.out.println("SERVICE: My ReviewList:"+customer_id);
		List<ReviewVO> reviewList = reviewDAO.selectMyReviewList(customer_id);
		
		for(ReviewVO review: reviewList) {
			String review_id = review.getReview_id();
			review.setPhotoList(reviewDAO.selectPhotoList(review_id));	
		}
		
		return reviewList;
	}

	@Override
	public void addReview(MultipartRequest multipartRequest, ReviewVO reviewVO) throws Exception {
		System.out.println("SERVICE: addReivew");
		/* 글 처리 */
		String review_id =reviewDAO.selectNewReviewID();
		reviewVO.setReview_id(review_id);
		reviewDAO.insertReview(reviewVO);
		/* 첨부파일 처리 */
		List<MultipartFile> files = multipartRequest.getFiles("images");
		System.out.println("files"+files);
		List<ReviewImageVO> fileList = new ArrayList<ReviewImageVO>();
		//List<String> fileNames = new ArrayList<String>();
        if (null != files && files.size() > 0){
            for (MultipartFile multipartFile : files) {
            	String fileName = uploadFile(multipartFile); //파일 한개씩 업로드
            	final String image_id= UUID.randomUUID().toString();
            	System.out.println("uuid:" + image_id);
            	ReviewImageVO reviewImageVO = new ReviewImageVO();
                reviewImageVO.setFileName(fileName);
                reviewImageVO.setImage_id(image_id);
                reviewImageVO.setReview_id(review_id);
                fileList.add(reviewImageVO);
                reviewDAO.insertReviewImg(reviewImageVO); // 리뷰이미지정보 table에 이미지 정보를 저장
	        	
            }
            reviewVO.setPhotoList(fileList);
        }
	}
	
	@Override
	public void modReview(ReviewVO reviewVO) throws Exception {
		//글 처리
		reviewDAO.updateReview(reviewVO);
		System.out.println("SERVICE: mod review");
		String review_id = reviewVO.getReview_id();
		
	}
	
	@Override
	public void removeReview(String review_id) {
		/* delete from db */
		reviewDAO.deleteReview(review_id);
		reviewDAO.deletePhotoList(review_id);
		//List<ReviewImageVO> fileList = reviewVO.getPhotoList();
		/* delete files */
		/*
		 * for(ReviewImageVO imageVO: fileList) { String fileName =
		 * imageVO.getFileName(); deleteFile(fileName); }
		 */
	}
	
	
	@Override
	public void calScore(String restaurant_license) {
		reviewDAO.calScore(restaurant_license);
	}
	
}
