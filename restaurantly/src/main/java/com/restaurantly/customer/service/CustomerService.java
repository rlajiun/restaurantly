package com.restaurantly.customer.service;

import java.util.Map;

import com.restaurantly.customer.vo.CustomerVO;

/*
 * 회원 리스트 출력 회원 등록 회원 수정 회원 삭제
 */

public interface CustomerService {

	public CustomerVO login(Map<String, String> loginMap) throws Exception;

	public void addCustomer(CustomerVO customerVO) throws Exception;

}