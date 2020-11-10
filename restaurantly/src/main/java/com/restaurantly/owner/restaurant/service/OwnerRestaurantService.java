package com.restaurantly.owner.restaurant.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.restaurantly.restaurant.vo.MenuVO;
import com.restaurantly.restaurant.vo.RestaurantVO;

public interface OwnerRestaurantService {

	public RestaurantVO restaurantInfo(String owner_id) throws Exception;

	public void addRestaurant(RestaurantVO restaurantVO, MultipartFile file) throws Exception;

	public void editRestaurant(RestaurantVO restaurantVO, MultipartFile file) throws Exception;

	public void addMenuList(MenuVO menuVO, List<MultipartFile> fileList) throws Exception;

	public List<String> listCategory() throws Exception;

	public void editMenuList(MenuVO menuVO, List<MultipartFile> fileList) throws Exception;

	public void delMenu(String menu_id) throws Exception;

	public void updateResId(Map<String, String> updateMap) throws Exception;

}
