package com.restaurantly.owner.restaurant.controller;

import java.util.HashMap;
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
import org.springframework.web.servlet.ModelAndView;

import com.restaurantly.owner.restaurant.service.OwnerRestaurantService;
import com.restaurantly.restaurant.vo.RestaurantVO;

@Controller
@RequestMapping(value = "/owner/restaurant")
public class OwnerRestaurantController {
	@Autowired
	private RestaurantVO restaurantVO;
	@Autowired
	private OwnerRestaurantService ownerRestaurantService;

	@RequestMapping(value = "/restaurantMain.do", method = RequestMethod.GET)
	public ModelAndView restaurantInfo(@RequestParam("owner_id") String owner_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session;

		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		session = request.getSession();

		try {
			restaurantVO = ownerRestaurantService.restaurantInfo(owner_id);
			System.out.println(restaurantVO);
			session.setAttribute("myRestaurant", restaurantVO);
			mav.addObject("page", "main");
		} catch (Exception e) {
			e.printStackTrace();
			viewName = "/owner/restaurant/addRestaurantForm";
			mav.setViewName(viewName);
			String msg = "불러오기 실패";
			mav.addObject("msg", msg);
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
			//TODO: 한 owner가 여러 식당 등록 불가능하게 하기 - 식당이 있으면 뷰에서 막기
			ownerRestaurantService.addRestaurant(restaurantVO, file);
			System.out.println(restaurantVO);
			msg = restaurantVO.getRestaurant_name() + " 등록 되었습니다.";
			url = request.getContextPath() + "/owner/restaurant/restaurantMain.do?owner_id="
					+ restaurantVO.getOwner_id();
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
			url = request.getContextPath() + "/owner/restaurant/restaurantMain.do?owner_id="
					+ restaurantVO.getOwner_id();
		} catch (Exception e) {
			msg = "수정에 실패했습니다. 정보를 확인해주세요.";
			e.printStackTrace();
		}
		editMap.put("msg", msg);
		editMap.put("url", url);

		return editMap;
	}
}
