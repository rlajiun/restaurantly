package com.restaurantly.owner.user.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.restaurantly.owner.user.service.OwnerService;
import com.restaurantly.owner.user.vo.OwnerVO;

@Controller("ownerController")
@RequestMapping(value = "/owner")
public class OwnerControllerImpl implements OwnerController {
	@Autowired
	private OwnerService ownerService;
	@Autowired
	private OwnerVO ownerVO;

	@Override
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam Map<String, String> loginMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		ownerVO = ownerService.login(loginMap);
		if (ownerVO != null && ownerVO.getOwner_id() != null) {
			HttpSession session = request.getSession();
			session = request.getSession();
			session.setAttribute("owner", ownerVO);

			String action = (String) session.getAttribute("action");
			if (action != null && action.equals("/booking/bookList.do")) {
				mav.setViewName("forward:" + action);
			} else {
				mav.setViewName("redirect:owner/main/main.do");
			}

		} else {
			String message = "아이디 또는 비밀번호를 확인해주세요!";
			mav.addObject("message", message);
			mav.setViewName("/loginForm");
		}
		return mav;
	}

	@Override
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		session.removeAttribute("owner");
		mav.setViewName("redirect:/main/main.do");
		return mav;
	}

	@Override
	@RequestMapping(value = "/addOwner.do", method = RequestMethod.POST)
	public ResponseEntity addOwner(@ModelAttribute("ownerVO") OwnerVO ownerVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			ownerService.addOwner(ownerVO);
			message = "<script>";
			message += " alert('회원가입 완료!');";
			message += " location.href='" + request.getContextPath() + "/loginForm.do';";
			message += " </script>";

		} catch (Exception e) {
			message = "<script>";
			message += " alert('이미 존재하는 회원입니다.');";
			message += " location.href='" + request.getContextPath() + "/joinForm.do';";
			message += " </script>";
			e.printStackTrace();
		}
		resEntity = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}

	@Override
	@RequestMapping(value = "/overlapped.do", method = RequestMethod.POST)
	public ResponseEntity overlapped(@RequestParam("owner_id") String owner_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ResponseEntity resEntity = null;
		String result = ownerService.overlapped(owner_id);
		resEntity = new ResponseEntity(result, HttpStatus.OK);
		return resEntity;
	}

}
