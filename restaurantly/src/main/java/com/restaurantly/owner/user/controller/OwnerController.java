package com.restaurantly.owner.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.restaurantly.common.base.BaseService;
import com.restaurantly.owner.user.service.OwnerService;
import com.restaurantly.owner.user.vo.OwnerVO;

@Controller("ownerController")
@RequestMapping(value = "/owner")
public class OwnerController extends BaseService {
	@Autowired
	private OwnerService ownerService;
	@Autowired
	private OwnerVO ownerVO;

	@ResponseBody
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public Map<String, String> login(@RequestParam Map<String, String> loginMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> ckloginMap = new HashMap<String, String>();
		String msg = null;
		String url = null;
		ownerVO = ownerService.login(loginMap);
		System.out.println(ownerVO);
		if (ownerVO != null && ownerVO.getOwner_id() != null) {
			HttpSession session = request.getSession();
			session.setAttribute("owner", ownerVO);

//			String action = (String) session.getAttribute("action");
//			if (action != null) {
//				url = request.getContextPath() + action + ".do";
//				session.removeAttribute("action");
//			} else {
//			}

			url = request.getContextPath() + "/owner/main.do";
		} else {
			msg = "아이디와 비밀번호를 확인해주세요.";
		}
		ckloginMap.put("msg", msg);
		ckloginMap.put("url", url);
		
		return ckloginMap;
	}

	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		session.removeAttribute("owner");
		session.removeAttribute("myRestaurant");
//		session.removeAttribute("action");
		mav.setViewName("redirect:/main.do");
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "/addOwner.do", method = RequestMethod.POST)
	public Map<String, String> addOwner(@ModelAttribute("ownerVO") OwnerVO ownerVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		System.out.println(ownerVO);
		Map<String, String> joinMap = new HashMap<String, String>();
		String msg = null;
		String url = null;
		try {
			ownerService.addOwner(ownerVO);
			msg = "회원가입 완료";
			url = request.getContextPath() + "/form/loginForm.do";
		} catch (Exception e) {
			msg = "이미 존재하는 회원입니다.";
			e.printStackTrace();
		}
		joinMap.put("msg", msg);
		joinMap.put("url", url);
		
		return joinMap;
	}

	@RequestMapping(value = "/overlapped.do", method = RequestMethod.POST)
	public ResponseEntity overlapped(@RequestParam("owner_id") String owner_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ResponseEntity resEntity = null;
		String result = ownerService.overlapped(owner_id);
		resEntity = new ResponseEntity(result, HttpStatus.OK);
		return resEntity;
	}

}
