package com.restaurantly.owner.restaurant.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.restaurantly.common.base.BaseService;
import com.restaurantly.owner.restaurant.dao.OwnerRestaurantDAO;
import com.restaurantly.restaurant.vo.MenuVO;
import com.restaurantly.restaurant.vo.RestaurantVO;

@Service("ownerRestaurantService")
@Transactional
public class OwnerRestaurantServiceImpl extends BaseService implements OwnerRestaurantService {
	private static final String CURR_IMAGE_REPO_PATH = "C:\\restaurantly\\file_repo";
	@Autowired
	private OwnerRestaurantDAO ownerRestaurantDAO;

	@Override
	public RestaurantVO restaurantInfo(String license) throws Exception {
		RestaurantVO restaurant = ownerRestaurantDAO.selectRestaurant(license);
		try {
			restaurant.setMenuList(ownerRestaurantDAO.selectMenuList(license));
			restaurant.setPhotoList(ownerRestaurantDAO.selectPhotoList(license));			
		} catch (Exception e) {
			e.printStackTrace();
		}
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
			throw e;
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

	@Override
	public void addMenuList(MenuVO menuVO, List<MultipartFile> fileList) throws Exception {
		List<MenuVO> menuList = menuVO.getMenuList();
		System.out.println("service 접근");
		System.out.println(fileList.size());
		List<String> fileNameList = new ArrayList<String>();
		for (int i = 0; i < fileList.size(); i++) {
			String fileName = uploadOne(fileList.get(i));
			System.out.println(fileName + " file 접근");
			if (fileName != null) {
				menuList.get(i).setMenu_image(fileName);
				fileNameList.add(fileName);
			}
		}
		try {
			ownerRestaurantDAO.insertMenu(menuList);
			if (fileNameList != null && fileNameList.size() != 0) {
				for (String fname : fileNameList) {
					File srcFile = new File(CURR_IMAGE_REPO_PATH + "\\" + "temp" + "\\" + fname);
					File destDir = new File(CURR_IMAGE_REPO_PATH + "\\" + menuList.get(0).getRestaurant_license());
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
				}
			}
		} catch (Exception e) {
			System.out.println("service catch");
			if (fileList != null && fileList.size() != 0) {
				for (String fname : fileNameList) {
					File srcFile = new File(CURR_IMAGE_REPO_PATH + "\\" + "temp" + "\\" + fname);
					srcFile.delete();
				}
			}
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public List<String> listCategory() throws Exception {
		List<String> categoryList = ownerRestaurantDAO.selectCategory();
		return categoryList;
	}

	@Override
	public void editMenuList(MenuVO menuVO, List<MultipartFile> fileList) throws Exception {
		List<MenuVO> menuList = menuVO.getMenuList();
		System.out.println("service 접근");
		System.out.println(fileList.size());
		List<String> fileNameList = new ArrayList<String>();
		List<MenuVO> updateMenuList = new ArrayList<MenuVO>();
		List<MenuVO> insertMenuList = new ArrayList<MenuVO>();
		for (int i = 0; i < fileList.size(); i++) {
			String fileName = uploadOne(fileList.get(i));
			System.out.println(fileName + " file 접근");
			if (!fileName.equals("") && fileName != null) {
				menuList.get(i).setMenu_image(fileName);
				fileNameList.add(fileName);
			}
			System.out.println(menuList.get(i));
			if (menuList.get(i).getMenu_id() != null) {
				updateMenuList.add(menuList.get(i));
			} else {
				insertMenuList.add(menuList.get(i));
			}
		}

		try {
			ownerRestaurantDAO.updateMenu(updateMenuList);
			ownerRestaurantDAO.insertMenu(insertMenuList);
			if (fileNameList != null && fileNameList.size() != 0) {
				for (String fname : fileNameList) {
					File srcFile = new File(CURR_IMAGE_REPO_PATH + "\\" + "temp" + "\\" + fname);
					File destDir = new File(CURR_IMAGE_REPO_PATH + "\\" + menuList.get(0).getRestaurant_license());
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
				}
			}
		} catch (Exception e) {
			System.out.println("service catch");
			if (fileList != null && fileList.size() != 0) {
				for (String fname : fileNameList) {
					File srcFile = new File(CURR_IMAGE_REPO_PATH + "\\" + "temp" + "\\" + fname);
					srcFile.delete();
				}
			}
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void delMenu(String menu_id) throws Exception {
		ownerRestaurantDAO.deleteMenu(menu_id);		
	}

	@Override
	public void updateResId(Map<String, String> updateMap) throws Exception {
		ownerRestaurantDAO.updateOwner(updateMap);
	}

}
