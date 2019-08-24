package com.alpha.file.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alpha.file.service.FileUploadService;

@Controller
public class FileUploadController {

	
	
	@Autowired
	private FileUploadService fileUploadService;
	
	/**
	 * 单文件上传
	* handleFileUpload(这里用一句话描述这个方法的作用)
	* @param lion
	* @param @return 设定文件
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/uploadFile")
	public String handleFileUpload(@RequestParam("name") String name,
								   @RequestParam("file") MultipartFile file,
								   RedirectAttributes redirectAttributes) {
		if (name.contains("/") ||name.contains(".")) {
			redirectAttributes.addFlashAttribute("message", "Folder separators not allowed");
			return "redirect:/";
		}
	

		if (!file.isEmpty()) {
			try {
				fileUploadService.uploadFile(file, name);
				redirectAttributes.addFlashAttribute("message",
						"You successfully uploaded " + name + "!");
			}
			catch (Exception e) {
				redirectAttributes.addFlashAttribute("message",
						"You failed to upload " + name + " => " + e.getMessage());
			}
		}
		else {
			redirectAttributes.addFlashAttribute("message",
					"You failed to upload " + name + " because the file was empty");
		}

		return "redirect:/hello";
	}
	
}
