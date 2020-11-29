package com.restaurantly.review.vo;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@NoArgsConstructor
@Getter @Setter
public class ReviewImageVO{
	
	private String image_id; // 이미지 순서 0~n개
	private String review_id; 
	private String fileName; // uuid
}
