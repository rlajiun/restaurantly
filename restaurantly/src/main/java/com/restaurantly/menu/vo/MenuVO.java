package com.restaurantly.menu.vo;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@NoArgsConstructor
@Getter @Setter
public class MenuVO {
	private String menu_id; /* 메뉴ID */
	private String restaurant_license; /* 사업자등록번호 */
	private String menu_name; /* 메뉴명 */
	private String menu_category; /* 메뉴분류 */
	private int menu_price; /* 가격 */
	private String menu_image_path; /* 사진경로 */
}