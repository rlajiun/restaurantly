package com.restaurantly.owner.user.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.restaurantly.owner.user.vo.OwnerVO;

@Repository("OwnerDAO")
public class OwnerDAOImpl implements OwnerDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public OwnerVO login(Map<String, String> loginMap) throws DataAccessException {
		OwnerVO owner = (OwnerVO) sqlSession.selectOne("mapper.owner.login", loginMap);
		return owner;
	}

	@Override
	public void insertNewOwner(OwnerVO ownerVO) throws DataAccessException {
		sqlSession.insert("mapper.owner.insertNewOwner", ownerVO);
	}

	@Override
	public String selectOverlappedID(String owner_id) throws DataAccessException {
		String result = sqlSession.selectOne("mapper.owner.selectOverlappedID", owner_id);
		return result;
	}

}
