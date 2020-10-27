package com.restaurantly.owner.user.service;

import java.util.Map;

import com.restaurantly.owner.user.vo.OwnerVO;

public interface OwnerService {
	public OwnerVO login(Map loginMap) throws Exception;

	public void addOwner(OwnerVO ownerVO) throws Exception;

	public String overlapped(String owner_id) throws Exception;
}
