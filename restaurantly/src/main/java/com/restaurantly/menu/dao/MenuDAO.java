package com.restaurantly.menu.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.restaurantly.menu.vo.MenuVO;

public interface MenuDAO {
	public List<String> selectMenuCategory() throws DataAccessException;
	public List<MenuVO> selectCatMenuList(String menu_category) throws DataAccessException;
	public List<MenuVO> selectMenuList(String restaurant_license) throws DataAccessException;
}
