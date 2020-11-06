package com.restaurantly.common.base;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@NoArgsConstructor
@Getter @Setter
public class ImageVO {
	private String image_id; /* 이미지ID */
	private String fileName; /* 이미지ID */

	public void setFileType(String fileName) {
		// TODO Auto-generated method stub
		
	}
	public void setFileName(String originalFileName) {
		this.fileName = fileName;
	}

}
