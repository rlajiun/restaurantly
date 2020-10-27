package com.restaurantly.customer.service;

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
	public CustomerVO addmember(CustomerVO customerVO) throws DataAccessException {
		customerDAO.addmember(customerVO);
		return customerVO;
	}

	@Override
	public CustomerVO modmember(CustomerVO customerVO) throws DataAccessException {
		customerDAO.modmember(customerVO);
		return customerVO;
	}

	@Override
	public CustomerVO deletemember(CustomerVO customerVO) throws DataAccessException {
		customerDAO.deletemember(customerVO);
		return customerVO;
	}

}
