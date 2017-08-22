package com.finra.exercise.fileupload.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;


/**
 * File upload service uploads the file and updates the file meta-data
 * 
 * @author garun
 * @version 1.0.0
 */
public interface FileUploadService {

	/**
	 * Uploads a file 
	 * 
	 * @param file name of the file
	 * @param group file meta-data group
	 * @param alias file meta-data alias
	 * @throws IOException checked exception
	 */
	void uploadFile(MultipartFile file, String group, String alias) throws IOException;

}