package com.restaurantly.owner.restaurant.service;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.restaurantly.common.base.BaseService;
import com.restaurantly.owner.restaurant.dao.OwnerRestaurantDAO;
import com.restaurantly.restaurant.vo.RestaurantVO;

@Service("ownerRestaurantService")
public class OwnerRestaurantServiceImpl extends BaseService implements OwnerRestaurantService {
	private static final String CURR_IMAGE_REPO_PATH = "C:\\restaurantly\\file_repo";
	@Autowired
	private OwnerRestaurantDAO ownerRestaurantDAO;

	@Override
	public RestaurantVO restaurantInfo(String owner_id) throws Exception {
		RestaurantVO restaurant = ownerRestaurantDAO.selectRestaurant(owner_id);
		return restaurant;
	}

	@Override
	public void addRestaurant(RestaurantVO restaurantVO, MultipartFile file) throws Exception {
		String fileName = uploadOne(file);
		try {
			restaurantVO.setRestaurant_image_path(fileName);
			ownerRestaurantDAO.insertRestaurant(restaurantVO);
			if (fileName != null) {
				File srcFile = new File(CURR_IMAGE_REPO_PATH + "\\" + "temp" + "\\" + fileName);
				File destDir = new File(CURR_IMAGE_REPO_PATH + "\\" + restaurantVO.getRestaurant_license());
				FileUtils.moveFileToDirectory(srcFile, destDir, true);
			}
		} catch (Exception e) {
			if (fileName != null) {
				File srcFile = new File(CURR_IMAGE_REPO_PATH + "\\" + "temp" + "\\" + fileName);
				srcFile.delete();
			}
			e.printStackTrace();
		}
	}

}
