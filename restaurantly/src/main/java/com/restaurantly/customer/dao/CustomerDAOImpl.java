package com.restaurantly.customer.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.restaurantly.customer.vo.CustomerVO;

@Repository("customerDAO")
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public CustomerVO login(Map<String, String> loginMap) throws DataAccessException {
		return (CustomerVO) sqlSession.selectOne("mapper.customer.login", loginMap);
	}

	@Override
	public void insertNewCustomer(CustomerVO customerVO) throws DataAccessException {
		sqlSession.insert("mapper.customer.insertNewCustomer", customerVO);
	}

}