package com.restaurantly.owner.restaurant.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.restaurantly.common.base.BaseController;
import com.restaurantly.menu.service.MenuService;
import com.restaurantly.menu.vo.MenuVO;
import com.restaurantly.owner.restaurant.service.OwnerRestaurantService;
import com.restaurantly.restaurant.vo.RestaurantVO;

@Controller
@RequestMapping(value = "/owner/restaurant")
public class OwnerRestaurantController extends BaseController {
	@Autowired
	private RestaurantVO restaurantVO;
	@Autowired
	private OwnerRestaurantService ownerRestaurantService;
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "/restaurantMain.do", method = RequestMethod.GET)
	public ModelAndView restaurantInfo(@RequestParam("owner_id") String owner_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		System.out.println(owner_id);
		restaurantVO = ownerRestaurantService.restaurantInfo(owner_id);
		System.out.println(restaurantVO);
		if (restaurantVO != null) {
			mav.addObject("restaurant", restaurantVO);
			System.out.println(restaurantVO.getRestaurant_license());
			List<MenuVO> menuList = menuService.listMenu(restaurantVO.getRestaurant_license());
			mav.addObject("menuList", menuList);
		} else {
			viewName = "/owner/restaurant/addRestaurantForm";
			mav.setViewName(viewName);
			String msg = "불러오기 실패";
			mav.addObject("msg", msg);
		}
		
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "/addRestaurant.do", method = RequestMethod.POST)
	public Map<String, String> addRestaurant(@ModelAttribute("restaurantVO") RestaurantVO restaurantVO, @RequestParam("file") MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> addMap = new HashMap<String, String>();
		String msg = null;
		String url = null;
		try {
//			restaurantVO.setRestaurant_image_path(uploadOne(file, restaurantVO.getRestaurant_license()));
//			if(imageFileList!= null && imageFileList.size()!=0) {				
//			    adminGoodsService.modifyGoodsImage(imageFileList);
//				for(ImageFileVO  imageFileVO:imageFileList) {
//					imageFileName = imageFileVO.getFileName();
//					File srcFile = new File(CURR_IMAGE_REPO_PATH+"\\"+"temp"+"\\"+imageFileName);
//					File destDir = new File(CURR_IMAGE_REPO_PATH+"\\"+goods_id);
//					FileUtils.moveFileToDirectory(srcFile, destDir,true);
//				}
//			}
			ownerRestaurantService.addRestaurant(restaurantVO);
			System.out.println(restaurantVO);
			msg = "식당 등록 완료";
			url = request.getContextPath() + "/owner/restaurant/restaurantMain.do?owner_id=${owner.owner_id}";
		} catch (Exception e) {
			msg = "등록 실패했습니다. 정보를 확인해주세요.";
			e.printStackTrace();
		}
		addMap.put("msg", msg);
		addMap.put("url", url);
		
		return addMap;
	}
}
