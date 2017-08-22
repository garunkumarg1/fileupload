package com.finra.exercise.fileupload.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Data Model
 * 
 * @author garun
 * @version 1.0.0
 */
@Entity
@Table(name = "FILE_DETAIL")
public class FileDetail {

	/**
	 * Id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	/**
	 * group name - provided meta-data
	 */
	String groupName;
	/**
	 * alias name - provided meta-data
	 */
	String aliasName;
	/**
	 * file name
	 */
	String fileName;
	/**
	 * file path - generated meta-data
	 */
	String filePath;
	/**
	 * file size - generated meta-data
	 */
	long fileSize;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	@Override
	public String toString() {
		return "FileDetail{" + "id=" + id + "file='" + fileName + "\'" + "filePath='" + filePath + "fileSize="
				+ fileSize + "\'" + "group='" + groupName + "\'" + "alias='" + aliasName + "\'" + "}";
	}

}
