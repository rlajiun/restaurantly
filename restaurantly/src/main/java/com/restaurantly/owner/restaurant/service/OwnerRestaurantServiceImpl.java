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
		String license = restaurant.getRestaurant_license();
		restaurant.setMenuList(ownerRestaurantDAO.selectMenuList(license));
		restaurant.setPhotoList(ownerRestaurantDAO.selectPhotoList(license));
		return restaurant;
	}

	@Override
	public void addRestaurant(RestaurantVO restaurantVO, MultipartFile file) throws Exception {
		String fileName = uploadOne(file);
		try {
			restaurantVO.setRestaurant_image(fileName);
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

	@Override
	public void editRestaurant(RestaurantVO restaurantVO, MultipartFile file) throws Exception {
		if (!file.isEmpty()) {
			String fileName = uploadOne(file);

			try {
				restaurantVO.setRestaurant_image(fileName);
				ownerRestaurantDAO.updateRestaurant(restaurantVO);
				// TODO: 나중에 update 전 사진들도 모아서 볼 수 있게 만들어보자! 카톡 프로필 사진들처럼 필요없는 사진들도 삭제하고!!
				// update하면서 같이 삭제할 필요는 없지
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
		} else {
			ownerRestaurantDAO.updateRestaurant(restaurantVO);
		}
	}

}
