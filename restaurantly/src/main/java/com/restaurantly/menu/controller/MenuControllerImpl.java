package com.restaurantly.menu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.restaurantly.menu.service.MenuService;
import com.restaurantly.menu.vo.MenuVO;

@Controller("MenuController")
@RequestMapping(value = "/menu")
public class MenuControllerImpl implements MenuController {
	@Autowired
	private MenuService menuService;

	@Override
	@RequestMapping(value = "/whatToEat.do", method = RequestMethod.GET)
	public ModelAndView listRandomMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		String menu_category = menuService.randomCat();
		List<MenuVO> catMenuList = menuService.listRandomMenuPic(menu_category);
		mav.addObject("menu_category", menu_category);
		mav.addObject("catMenuList", catMenuList);

		return mav;
	}

}
