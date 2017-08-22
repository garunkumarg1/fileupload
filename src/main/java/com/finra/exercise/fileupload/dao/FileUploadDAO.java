package com.finra.exercise.fileupload.dao;

import com.finra.exercise.fileupload.model.FileDetail;

/**
 * Persists file data model
 * 
 * @author garun
 * @version 1.0.0
 */
public interface FileUploadDAO {

	/**
	 * Create a file record
	 * 
	 * @param fileDetail file record details
	 */
	void create(FileDetail fileDetail);

	/**
	 * Get a file record
	 * 
	 * @param id file id
	 * @return file record details
	 */
	FileDetail getFileDetailById(long id);

	/**
	 * update a file record
	 * 
	 * @param fileDetail file record details
	 */
	void update(FileDetail fileDetail);

	/**
	 * delete a file record
	 * 
	 * @param id file id
	 */
	void delete(long id);

}