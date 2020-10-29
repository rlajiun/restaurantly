package com.restaurantly.customer.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurantly.customer.dao.CustomerDAO;
import com.restaurantly.customer.vo.CustomerVO;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService  {
	
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public CustomerVO login(Map<String, String> loginMap) {
		return customerDAO.login(loginMap);
	}

	@Override
	public void addCustomer(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		
	}
 	


}
