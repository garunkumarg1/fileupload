package com.finra.exercise.fileupload.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.finra.exercise.fileupload.dao.FileUploadDAO;
import com.finra.exercise.fileupload.model.FileDetail;

/**
 * File upload service uploads the file and updates the file meta-data
 * 
 * @author garun
 * @version 1.0.0
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {

	private static String FILE_UPLOAD_DESTINATION = "c://temp//";

	@Autowired
	private FileUploadDAO fileUploadDAO;
	
	private final Logger logger = LoggerFactory.getLogger(FileUploadServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.finra.exercise.fileupload.service.FileUploadService#uploadFile(org.
	 * springframework.web.multipart.MultipartFile, java.lang.String,
	 * java.lang.String)
	 */
	@Transactional
	public void uploadFile(MultipartFile file, String group, String alias) throws IOException {
		byte[] bytes = file.getBytes();
		Path path = Paths.get(FILE_UPLOAD_DESTINATION + file.getOriginalFilename());
		Files.write(path, bytes);
		FileDetail fileDetail = new FileDetail();
		fileDetail.setFileName(file.getOriginalFilename());
		fileDetail.setFilePath(path.toString());
		fileDetail.setFileSize(Files.size(path));
		fileDetail.setGroupName(group);
		fileDetail.setAliasName(alias);
		fileUploadDAO.create(fileDetail);
		logger.debug("file uploaded.");
	}
}
