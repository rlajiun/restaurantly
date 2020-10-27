package com.restaurantly.menu.service;

import java.util.List;

import com.restaurantly.menu.vo.MenuVO;

public interface MenuService {
	// 랜덤 음식 선택
	public String randomCat() throws Exception;
	// 랜덤 음식이 선택된 음식 사진들 모두 가져오기
	public List<MenuVO> listRandomMenuPic(String menu_category) throws Exception;
	// 해당 식당의 메뉴 불러오기
	public List<MenuVO> listMenu(String restaurant_license) throws Exception;
}
