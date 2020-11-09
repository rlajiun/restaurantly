package com.restaurantly.owner.booking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.restaurantly.booking.vo.BookingVO;
import com.restaurantly.owner.booking.service.OwnerBookingService;
import com.restaurantly.owner.user.vo.OwnerVO;

@Controller
@RequestMapping(value = "/owner/booking")
public class OwnerBookingController {
	@Autowired
	private OwnerBookingService ownerBookingService;

	@RequestMapping(value = "/myBookList.do", method = RequestMethod.GET)
	public ModelAndView bookList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);

		OwnerVO ownerVO = (OwnerVO) session.getAttribute("owner");
		try {
			String restaurant_license = ownerVO.getRestaurant_license();
			if (restaurant_license != null && !restaurant_license.equals("")) {
				List<BookingVO> bookList = ownerBookingService.booklist(restaurant_license);
				mav.addObject("bookList", bookList);
			} else {
				session.setAttribute("action", viewName);
				mav.setViewName("redirect:/owner/restaurant/addRestaurantForm.do");
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("action", viewName);
			mav.setViewName("redirect:/form/loginForm.do");
		}
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "/delTable.do", method = RequestMethod.POST)
	public String cancelTable(@RequestParam String booking_id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String msg = null;

		try {
			ownerBookingService.delTable(booking_id);
			msg = "OK";
		} catch (Exception e) {
			msg = "삭제 오류! 직접 연락해서 취소해주세요.";
			e.printStackTrace();
		}

		return msg;
	}
}
