package com.restaurantly.owner.restaurant.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.restaurantly.owner.restaurant.service.OwnerRestaurantService;
import com.restaurantly.owner.user.vo.OwnerVO;
import com.restaurantly.restaurant.vo.MenuVO;
import com.restaurantly.restaurant.vo.RestaurantVO;

@Controller
@RequestMapping(value = "/owner/restaurant")
public class OwnerRestaurantController {
	@Autowired
	private RestaurantVO restaurantVO;
	@Autowired
	private OwnerRestaurantService ownerRestaurantService;

	@RequestMapping(value = "/restaurantMain.do", method = RequestMethod.GET)
	public ModelAndView restaurantInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);

		OwnerVO owner = (OwnerVO) session.getAttribute("owner");
		System.out.println(owner);
		try {
			String res_license = owner.getRestaurant_license();
			if (res_license != null && !res_license.equals("")) {
				restaurantVO = ownerRestaurantService.restaurantInfo(res_license);
				System.out.println(restaurantVO);
				session.setAttribute("myRestaurant", restaurantVO);
				mav.addObject("page", "main"); // owner 식당 메인 페이지 확인해서 topbar 바꿔주기 용도

			} else {
				session.setAttribute("action", viewName);
				viewName = "/owner/restaurant/addRestaurantForm";
				mav.setViewName(viewName);
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("action", viewName);
			mav.setViewName("redirect:/form/loginForm.do");
		}
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "/addRestaurant.do", method = RequestMethod.POST)
	public Map<String, String> addRestaurant(@ModelAttribute("restaurantVO") RestaurantVO restaurantVO,
			@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, String> addMap = new HashMap<String, String>();
		String msg = null;
		String url = null;
		try {
			// TODO: 한 owner가 여러 식당 등록 불가능하게 하기 - 식당이 있으면 뷰에서 막기
			ownerRestaurantService.addRestaurant(restaurantVO, file);
			System.out.println(restaurantVO);
			msg = restaurantVO.getRestaurant_name() + " 등록 되었습니다.";
			url = request.getContextPath() + "/owner/restaurant/restaurantMain.do";
		} catch (Exception e) {
			msg = "등록에 실패했습니다. 정보를 확인해주세요.";
			e.printStackTrace();
		}
		addMap.put("msg", msg);
		addMap.put("url", url);

		return addMap;
	}

	@ResponseBody
	@RequestMapping(value = "/editRestaurant.do", method = RequestMethod.POST)
	public Map<String, String> editRestaurant(@ModelAttribute("restaurantVO") RestaurantVO restaurantVO,
			@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, String> editMap = new HashMap<String, String>();
		String msg = null;
		String url = null;
		try {
			ownerRestaurantService.editRestaurant(restaurantVO, file);
			System.out.println(restaurantVO);
			msg = restaurantVO.getRestaurant_name() + " 수정 되었습니다.";
			url = request.getContextPath() + "/owner/restaurant/restaurantMain.do";
		} catch (Exception e) {
			msg = "수정에 실패했습니다. 정보를 확인해주세요.";
			e.printStackTrace();
		}
		editMap.put("msg", msg);
		editMap.put("url", url);

		return editMap;
	}

	@ResponseBody
	@RequestMapping(value = "/addMenu.do", method = RequestMethod.POST)
	public Map<String, String> addMenu(@ModelAttribute("menuVO") MenuVO menuVO,
			MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception {
		Map<String, String> addMap = new HashMap<String, String>();
		List<MultipartFile> fileList = multipartRequest.getFiles("file");
		String msg = null;
		String url = null;
		try {
			ownerRestaurantService.addMenuList(menuVO, fileList);
			msg = "메뉴가 추가되었습니다.";
			url = multipartRequest.getContextPath() + "/owner/restaurant/restaurantMain.do";
		} catch (Exception e) {
			System.out.println("controller catch");
			msg = "저장에 실패했습니다. 정보를 확인해주세요.";
			e.printStackTrace();
		}
		addMap.put("msg", msg);
		addMap.put("url", url);

		return addMap;
	}

	@RequestMapping(value = { "/addMenuForm.do", "/editMenuForm.do" }, method = RequestMethod.GET)
	public ModelAndView printMenuForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		List<String> categoryList = ownerRestaurantService.listCategory();
		mav.addObject("categoryList", categoryList);

		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "/editMenu.do", method = RequestMethod.POST)
	public Map<String, String> editMenu(@ModelAttribute("menuVO") MenuVO menuVO,
			MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception {
		System.out.println("컨트롤러 접근!!!!!");
		Map<String, String> editMap = new HashMap<String, String>();
		List<MultipartFile> fileList = multipartRequest.getFiles("file");
		String msg = null;
		String url = null;
		try {
			ownerRestaurantService.editMenuList(menuVO, fileList);
			msg = "메뉴가 수정되었습니다.";
			url = multipartRequest.getContextPath() + "/owner/restaurant/restaurantMain.do";
		} catch (Exception e) {
			System.out.println("controller catch");
			msg = "저장에 실패했습니다. 정보를 확인해주세요.";
			e.printStackTrace();
		}
		editMap.put("msg", msg);
		editMap.put("url", url);

		return editMap;
	}

	@ResponseBody
	@RequestMapping(value = "/delMenu.do", method = RequestMethod.POST)
	public void delMenu(@RequestParam("menu_id") String menu_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			ownerRestaurantService.delMenu(menu_id);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
