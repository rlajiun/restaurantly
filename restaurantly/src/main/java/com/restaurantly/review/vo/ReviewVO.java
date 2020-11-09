package com.restaurantly.review.vo;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Component;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component("reviewVO")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReviewVO {
	private String review_id;
	private String restaurant_license;
	private String customer_id;
	private String review_content;
	private int review_score;
	private Date review_writedate;
	private String review_image_path;
	private List<ReviewImageVO> photoList; 


}
