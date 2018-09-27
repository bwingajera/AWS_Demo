package com.esense.s3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.esense.s3.config.S3Services;

@RestController
public class UploadFileController {

	@Autowired
	S3Services s3Services;
	
    @PostMapping("/api/file/upload")
    public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file) {
    	String keyName = file.getOriginalFilename();
		s3Services.uploadFile(keyName, file);
		return "Upload Successfully -> KeyName = " + keyName;
    }    
}
