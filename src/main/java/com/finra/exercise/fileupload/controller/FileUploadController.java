package com.finra.exercise.fileupload.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.finra.exercise.fileupload.service.FileUploadService;

/**
 * File upload controller
 * 
 * @author garun
 * @version 1.0.0
 */
@RestController
@RequestMapping("finra/v1")
public class FileUploadController {

	private final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	@Autowired
	private FileUploadService fileuploadService;

	/**
	 * Upload file to server file system and store file meta-data to In-Memory db instance.
	 * 
	 * @param uploadFile name of the file
	 * @param group file meta-data group
	 * @param alias file meta-data alias
	 * @return response
	 */
	@PostMapping("/fileupload")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadFile,
			@RequestParam("group") String group, @RequestParam("alias") String alias) {
		logger.debug("file upload started");
		
		if (uploadFile.isEmpty()) {
			return new ResponseEntity<String>("Provide file to upload", HttpStatus.BAD_REQUEST);
		}
		if (StringUtils.isEmpty(group)) {
			return new ResponseEntity<String>("Provide file group", HttpStatus.BAD_REQUEST);
		}
		if (StringUtils.isEmpty(alias)) {
			return new ResponseEntity<String>("Provide file alias", HttpStatus.BAD_REQUEST);
		}

		try {
			fileuploadService.uploadFile(uploadFile, group, alias);
		} catch (IOException e) {
			return new ResponseEntity<String>("File upload failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.debug("file upload completed");
		return new ResponseEntity<String>("File uploaded successfully -" + uploadFile.getOriginalFilename(),
				HttpStatus.OK);
	}

}
