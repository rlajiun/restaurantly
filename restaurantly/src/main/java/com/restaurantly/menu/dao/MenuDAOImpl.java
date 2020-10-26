package com.restaurantly.menu.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.restaurantly.menu.vo.MenuVO;

@Repository("menuDAO")
public class MenuDAOImpl implements MenuDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<String> selectMenuCategory() throws DataAccessException {
		List<String> menuCatList = (List)sqlSession.selectList("mapper.menu.selectMenuCategory");
		return menuCatList;
	}

	@Override
	public List<MenuVO> selectMenuList(String menu_category) throws DataAccessException {
		List<MenuVO> menuList = (List)sqlSession.selectList("mapper.menu.selectMenuList", menu_category);
		return menuList;
	}

}
