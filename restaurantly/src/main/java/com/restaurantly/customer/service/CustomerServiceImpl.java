package com.restaurantly.customer.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurantly.customer.dao.CustomerDAO;
import com.restaurantly.customer.vo.CustomerVO;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public CustomerVO login(Map<String, String> loginMap) throws Exception {
		return customerDAO.login(loginMap);
	}

	@Override
	public void addCustomer(CustomerVO customerVO) throws Exception {
		customerDAO.insertNewCustomer(customerVO);
	}

}