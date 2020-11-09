package com.restaurantly.common.base;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.restaurantly.review.vo.ReviewImageVO;

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

	/*
	 * protected List<ImageVO> upload(MultipartHttpServletRequest multipartRequest)
	 * throws Exception { List<ImageVO> fileList = new ArrayList<ImageVO>();
	 * Iterator<String> fileNames = multipartRequest.getFileNames(); while
	 * (fileNames.hasNext()) { ImageVO imageVO = new ImageVO(); String fileName =
	 * fileNames.next(); imageVO.setFileType(fileName); MultipartFile mFile =
	 * multipartRequest.getFile(fileName); String originalFileName =
	 * mFile.getOriginalFilename(); imageVO.setFileName(originalFileName);
	 * fileList.add(imageVO);
	 * 
	 * File file = new File(CURR_IMAGE_REPO_PATH + "\\" + fileName); if
	 * (mFile.getSize() != 0) { // File Null Check if (!file.exists()) { // ��λ�
	 * ������ �������� ���� ��� if (file.getParentFile().mkdirs()) { // ��ο� �ش��ϴ�
	 * ���丮���� ���� file.createNewFile(); // ���� ���� ���� } }
	 * mFile.transferTo(new File(CURR_IMAGE_REPO_PATH + "\\" + "temp" + "\\" +
	 * originalFileName)); // �ӽ÷�
	 * 
	 * } } }
	 */
		
	/* 파일 1개 업로드 */	
	public String uploadFile(MultipartFile multipartFile) throws Exception {
		String fileName = multipartFile.getOriginalFilename();
        System.out.println("fileName: " + fileName);
        //File imageFile = new File(servletRequest.getServletContext().getRealPath("/image"), fileName);
        File file = new File(CURR_IMAGE_REPO_PATH, fileName);
        try{
            multipartFile.transferTo(file);
        } catch (Exception e) {
            e.printStackTrace();
        }   
        return fileName;
	}

	/* 파일리스트 업로드 */
	public List<String> uploadFiles(List<MultipartFile> files) {
		List<String> fileNames = new ArrayList<String>();
        if (null != files && files.size() > 0){
            for (MultipartFile multipartFile : files) {
            	//String fileName = multipartFile.getOriginalFilename();
                final String fileName = UUID.randomUUID().toString();
                System.out.println("fileName, uuid = " + fileName);
                fileNames.add(fileName);
                //File imageFile = new File(servletRequest.getServletContext().getRealPath("/image"), fileName);
                File file = new File(CURR_IMAGE_REPO_PATH, fileName);
                try{
                    multipartFile.transferTo(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }   
            }
        }
        return fileNames;
	}
	
	
	protected void deleteFile(String fileName) {
		File file = new File(CURR_IMAGE_REPO_PATH + "\\" + fileName);
		try {
			file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
