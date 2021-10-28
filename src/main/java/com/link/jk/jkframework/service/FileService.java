package com.link.jk.jkframework.service;

import com.link.jk.jkframework.dto.FileDto;
import com.link.jk.jkframework.mapper.FileMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FileService {

	@Resource
	private FileMapper fileMapper;

	public void multiUpload(FileDto fileDto) {
		fileMapper.multiUpload(fileDto);
	}
}
