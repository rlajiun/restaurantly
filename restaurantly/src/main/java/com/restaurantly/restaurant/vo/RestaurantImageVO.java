package com.restaurantly.restaurant.vo;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@NoArgsConstructor
@Getter @Setter
@ToString
public class RestaurantImageVO {
	private String image_id; /* 이미지ID */
	private String restaurant_license; /* 사업자등록번호 */
	private String fileName; /*이미지파일명*/
	private String fileType; /* 이미지파일종류 */
}
