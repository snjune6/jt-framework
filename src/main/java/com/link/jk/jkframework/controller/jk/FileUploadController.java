package com.link.jk.jkframework.controller.jk;

import com.link.jk.jkframework.comm.Util;
import com.link.jk.jkframework.dto.FileDto;
import com.link.jk.jkframework.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/jk-framework/upload")
public class FileUploadController {

	@Value("${spring.servlet.multipart.location}")
	private String basePath;

	@Autowired
	private FileService fileService;

	@GetMapping("")
	public String uploadForm(HttpServletRequest request, HttpServletResponse response, Model model) {

		FileDto fileDto = new FileDto();
		model.addAttribute("fileDto", fileDto);

		return "jk/upload/form";
	}

	@PostMapping("")
	public String uploadAction(@RequestParam MultipartFile[] uploadFile, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {

		List<FileDto> list = new ArrayList<>();

		for(MultipartFile file : uploadFile) {
			if(!file.isEmpty()) {
				FileDto fileDto = new FileDto();
				fileDto.setOriginalfileName(file.getOriginalFilename());
				fileDto.setFileSize(file.getSize());
				fileDto.setFileType(file.getContentType());

				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
				SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HHmmSS");
				String current_date = simpleDateFormat.format(new Date());
				String current_date2 = simpleDateFormat2.format(new Date());

				fileDto.setFilePath(basePath + current_date + File.separator);
				fileDto.setFileName(current_date2 + "");

				File pathDir = new File(fileDto.getFilePath());

				if(!pathDir.exists()) {
					pathDir.mkdirs();
				}

				list.add(fileDto);

				File newFileName = new File(fileDto.getFilePath() + fileDto.getFileName() + "_" +fileDto.getOriginalfileName());

				file.transferTo(newFileName);

				fileService.multiUpload(fileDto);
			}
		}

		model.addAttribute("files", list);

		return "jk/upload/result";
	}

}
