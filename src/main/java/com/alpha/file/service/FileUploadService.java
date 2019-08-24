package com.alpha.file.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
	
	/**
	 * uploadFile(这里用一句话描述这个方法的作用)
	 * @param file 
	 */
	void uploadFile(MultipartFile file, String name) throws Exception;

}
