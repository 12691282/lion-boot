package com.alpha.file.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.alpha.file.service.FileUploadService;


@Service
public class FileUploadServiceImpl implements FileUploadService {

	private static final String  ROOT = "F:\\";
	
	@Override
	public void uploadFile(MultipartFile file, String name) throws Exception {
		
		
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(new File(ROOT + "/" + name)));
        FileCopyUtils.copy(file.getInputStream(), stream);
		stream.close();
		
	}

}
