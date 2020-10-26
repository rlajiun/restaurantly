package com.restaurantly.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.restaurantly.menu.dao.MenuDAO;
import com.restaurantly.menu.vo.MenuVO;

@Service("menuService")
@Transactional(propagation=Propagation.REQUIRED)
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDAO menuDAO;
	
	@Override
	public String randomCat() throws Exception {
		String menu_category;
		List<String> menuCatList = menuDAO.selectMenuCategory();
		int random = (int) (Math.random() * menuCatList.size());
		menu_category = menuCatList.get(random);
		return menu_category;
	}

	@Override
	public List<MenuVO> listRandomMenuPic(String menu_category) throws Exception {
		List<MenuVO> menuList = menuDAO.selectMenuList(menu_category);
		return menuList;
	}

}
