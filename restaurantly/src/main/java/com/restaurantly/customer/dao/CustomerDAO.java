package com.restaurantly.customer.dao;


import org.springframework.dao.DataAccessException;

import com.restaurantly.customer.vo.CustomerVO;



/*
 * 회원 리스트 출력 회원 등록 회원 수정 회원 삭제
 */

public interface CustomerDAO {
	public CustomerVO addmember(CustomerVO customerVO) throws DataAccessException;
	public CustomerVO modmember(CustomerVO customerVO) throws DataAccessException;
	public CustomerVO deletemember(CustomerVO customerVO) throws DataAccessException;

}