package com.restaurantly.customer.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.restaurantly.customer.vo.CustomerVO;

public class CustomerDAOImpl implements CustomerDAO  {
	@Autowired
	private SqlSession sqlSession;
 	

	@Override
	public CustomerVO addmember(CustomerVO customerVO) throws DataAccessException {
		sqlSession.insert("mapper.customer.insertNewMember",customerVO);
		return customerVO;
	}

	@Override
	public CustomerVO modmember(CustomerVO customerVO) throws DataAccessException {
		sqlSession.insert("mapper.customer.insertNewMember",customerVO);
		return customerVO;
	}

	@Override
	public CustomerVO deletemember(CustomerVO customerVO) throws DataAccessException {
		sqlSession.selectOne("mapper.customer.deletemember",customerVO);
		return customerVO;
	}

}
