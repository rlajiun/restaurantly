package com.restaurantly.owner.user.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.restaurantly.owner.user.dao.OwnerDAO;
import com.restaurantly.owner.user.vo.OwnerVO;

@Service("ownerService")
@Transactional(propagation = Propagation.REQUIRED)
public class OwnerServiceImpl implements OwnerService {
	@Autowired
	private OwnerDAO ownerDAO;

	@Override
	public OwnerVO login(Map loginMap) throws Exception {
		return ownerDAO.login(loginMap);
	}

	@Override
	public void addOwner(OwnerVO ownerVO) throws Exception {
		ownerDAO.insertNewOwner(ownerVO);
	}

	@Override
	public String overlapped(String owner_id) throws Exception {
		return ownerDAO.selectOverlappedID(owner_id);
	}

}
