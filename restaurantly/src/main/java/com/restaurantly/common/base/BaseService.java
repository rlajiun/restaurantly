package com.restaurantly.common.base;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class BaseService {
	private static final String CURR_IMAGE_REPO_PATH = "C:\\restaurantly\\file_repo";

	protected String uploadOne(MultipartFile file) throws Exception {
		String fileName = null;
		System.out.println(file);
		if (file != null) {
			fileName = file.getOriginalFilename();

			File target = new File(CURR_IMAGE_REPO_PATH + "\\" + fileName);
			System.out.println(target);
			if (file.getSize() != 0) { // File Null Check
				if (!target.exists()) {
					if (target.getParentFile().mkdirs()) {
						target.createNewFile();
					}
				}
				file.transferTo(new File(CURR_IMAGE_REPO_PATH + "\\" + "temp" + "\\" + fileName));
			}
		}
		return fileName;
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
