package com.restaurantly.booking.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.restaurantly.booking.service.BookingService;
import com.restaurantly.booking.vo.BookingVO;
import com.restaurantly.customer.vo.CustomerVO;

@Controller
@RequestMapping(value = "/booking")
public class BookingController {
	@Autowired
	private BookingService bookingService;
	
	@ResponseBody
	@RequestMapping(value = "/book-a-table.do", method = RequestMethod.POST)
	public Map<String, String> bookATable(@ModelAttribute BookingVO bookingVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> addMap = new HashMap<String, String>();
		String msg = null;
		
		try {
			System.out.println("예약: "+bookingVO);
			bookingService.bookATable(bookingVO);
			msg = "OK";
			
		} catch (Exception e) {
			msg = "예약에 성공하지 못했습니다. 전화를 통해 직접 예약해주세요.";
			e.printStackTrace();
		}
		
		addMap.put("msg", msg);

		return addMap;
	}
	
	@RequestMapping(value = "/myBookList.do", method = RequestMethod.GET)
	public ModelAndView myBookList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		CustomerVO customerVO = (CustomerVO)session.getAttribute("customer");
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		System.out.println(viewName);
		try {
			String customer_id = customerVO.getCustomer_id();
			if (customer_id !=null && !customer_id.equals("")) {
				System.out.println(customer_id);
				List<BookingVO> bookingList = bookingService.listBooking(customer_id);
				mav.addObject("bookingList", bookingList);
			}else {
				session.setAttribute("action", viewName);
				mav.setViewName("redirect:/form/loginForm.do");
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("action", viewName);
//			mav.setViewName("redirect:/form/loginForm.do");
		}
		
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "/cancelTable.do", method = RequestMethod.POST)
	public String cancelTable(@RequestParam String booking_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String msg = null;
		
		try {
			bookingService.cancelTable(booking_id);
			msg = "OK";
		} catch (Exception e) {
			msg = "취소 오류! 직접 연락해서 취소해주세요.";
			e.printStackTrace();
		}

		return msg;
	}
}
