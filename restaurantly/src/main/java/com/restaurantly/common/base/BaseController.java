package com.restaurantly.common.base;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

public class BaseController {
	@RequestMapping(value = { "*/*Form.do", "*/*/*Form.do" }, method = { RequestMethod.POST, RequestMethod.GET })
	protected ModelAndView viewForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}

	private static final String CURR_IMAGE_REPO_PATH = "C:\\restaurantly\\file_repo";

	protected String uploadOne(MultipartFile file, String dir) throws Exception {
		String fileName = null;
		while (file != null) {
			fileName = file.getOriginalFilename();

			File target = new File(CURR_IMAGE_REPO_PATH + "\\" + fileName);
			if (file.getSize() != 0) { // File Null Check
				if (!target.exists()) { 
					if (target.getParentFile().mkdirs()) { 
						target.createNewFile();					
						}
				}
				file.transferTo(new File(CURR_IMAGE_REPO_PATH + "\\" + "temp" + "\\" + fileName));
			}
		}
		return CURR_IMAGE_REPO_PATH + "\\" + fileName;
	}

//	protected List<ImageFileVO> upload(MultipartHttpServletRequest multipartRequest) throws Exception {
//		List<ImageFileVO> fileList = new ArrayList<ImageFileVO>();
//		Iterator<String> fileNames = multipartRequest.getFileNames();
//		while (fileNames.hasNext()) {
//			ImageFileVO imageFileVO = new ImageFileVO();
//			String fileName = fileNames.next();
//			imageFileVO.setFileType(fileName);
//			MultipartFile mFile = multipartRequest.getFile(fileName);
//			String originalFileName = mFile.getOriginalFilename();
//			imageFileVO.setFileName(originalFileName);
//			fileList.add(imageFileVO);
//			
//			File file = new File(CURR_IMAGE_REPO_PATH + "\\" + fileName);
//			if (mFile.getSize() != 0) { // File Null Check
//				if (!file.exists()) { // ��λ� ������ �������� ���� ���
//					if (file.getParentFile().mkdirs()) { // ��ο� �ش��ϴ� ���丮���� ����
//						file.createNewFile(); // ���� ���� ����
//					}
//				}
//				mFile.transferTo(new File(CURR_IMAGE_REPO_PATH + "\\" + "temp" + "\\" + originalFileName)); // �ӽ÷�
//				// �����
//				// multipartFile��
//				// ����
//				// ���Ϸ�
//				// ����
//			}
//		}
//		return fileList;
//	}

	private void deleteFile(String fileName) {
		File file = new File(CURR_IMAGE_REPO_PATH + "\\" + fileName);
		try {
			file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
