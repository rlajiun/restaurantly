package com.restaurantly.owner.user.dao;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.restaurantly.owner.user.vo.OwnerVO;

public interface OwnerDAO {
	public OwnerVO login(Map loginMap) throws DataAccessException;
	public void insertNewOwner(OwnerVO ownerVO) throws DataAccessException;
	public String selectOverlappedID(String owner_id) throws DataAccessException;
}
