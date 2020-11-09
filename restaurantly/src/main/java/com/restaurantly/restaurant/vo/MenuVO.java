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
public class MenuVO {
	private String menu_id; /* 메뉴ID */
	private String restaurant_license; /* 사업자등록번호 */
	private String menu_name; /* 메뉴명 */
	private String menu_category; /* 메뉴분류 */
	private int menu_price; /* 가격 */
	private String menu_image; /* 사진경로 */
	private String menu_description; /* 메뉴설명 */
	private List<MenuVO> menuList;
}