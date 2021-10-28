package com.link.jk.jkframework.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class FileDto {

	private MultipartFile[] uploadFile;
	private String originalfileName;
	private String fileName;
	private String filePath;
	private long fileSize;
	private String fileType;

}
