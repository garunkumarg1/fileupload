package com.finra.exercise.fileupload.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.finra.exercise.fileupload.model.FileDetail;

/**
 * Persists file data model
 * 
 * @author garun
 * @version 1.0.0
 */
@Repository
public class FileUploadDAOImpl implements FileUploadDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	private final Logger logger = LoggerFactory.getLogger(FileUploadDAOImpl.class);

	/* (non-Javadoc)
	 * @see com.finra.exercise.fileupload.dao.FileUploadDAO1#create(com.finra.exercise.fileupload.model.FileDetail)
	 */
	public void create(FileDetail fileDetail) {
		entityManager.persist(fileDetail);
		logger.debug("file record persisted");
	}

	/* (non-Javadoc)
	 * @see com.finra.exercise.fileupload.dao.FileUploadDAO1#getFileDetailById(long)
	 */
	public FileDetail getFileDetailById(long id) {
		return entityManager.find(FileDetail.class, id);
		
	}

	/* (non-Javadoc)
	 * @see com.finra.exercise.fileupload.dao.FileUploadDAO1#update(com.finra.exercise.fileupload.model.FileDetail)
	 */
	public void update(FileDetail fileDetail) {
		entityManager.merge(fileDetail);
		logger.debug("file record updated");
	}

	/* (non-Javadoc)
	 * @see com.finra.exercise.fileupload.dao.FileUploadDAO1#delete(long)
	 */
	public void delete(long id) {
		FileDetail fileDetail = getFileDetailById(id);
		if (fileDetail != null) {
			entityManager.remove(fileDetail);
			logger.debug("file record deleted");
		}
	}

}
