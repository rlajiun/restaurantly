package com.restaurantly.review.vo;

import org.springframework.stereotype.Component;

import com.restaurantly.common.base.ImageVO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@NoArgsConstructor
@Getter @Setter
public class ReviewImageVO extends ImageVO{
	private String image_id; /* 이미지ID */
	private String review_id; 
	private String fileName; /*이미지파일명*/
}
