package com.restaurantly.restaurant.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@NoArgsConstructor
@Getter @Setter
@ToString
public class RestaurantVO {
	private String restaurant_license; /* 사업자등록번호 */
	private String owner_id; /* 판매자ID */
	private String restaurant_name; /* 업소명 */
	private String restaurant_phone; /* 소재지전화 */
	private String restaurant_representative; /* 대표자명 */
	private String restaurant_detail; /* 소재지(도로명) */
	private String restaurant_item; /* 소재지(도로명) */
	private String restaurant_introduction; /* 소개글 */
	private String restaurant_image; /* 사진경로 */
	private List<MenuVO> menuList; /* 메뉴정보 */
	private List<RestaurantImageVO> photoList; /* 사진정보 */
}
