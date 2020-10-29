package com.restaurantly.customer.dao;


import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.restaurantly.customer.vo.CustomerVO;

/*
 * 회원 리스트 출력 회원 등록 회원 수정 회원 삭제
 */

public interface CustomerDAO {

	CustomerVO login(Map<String, String> loginMap);
	

}