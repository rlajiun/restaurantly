package com.restaurantly.menu.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.restaurantly.menu.vo.MenuVO;

public interface MenuDAO {
	public List<String> selectMenuCategory() throws DataAccessException;
	public List<MenuVO> selectMenuList(String menu_category) throws DataAccessException;
}
