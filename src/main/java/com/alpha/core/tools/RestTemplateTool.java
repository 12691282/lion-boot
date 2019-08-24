package com.alpha.core.tools;

import org.springframework.web.client.RestTemplate;

public class RestTemplateTool {

	private final static RestTemplate RestTemplate = new RestTemplate();

	public static RestTemplate getResttemplate() {
		return RestTemplate;
	} 
	
}
