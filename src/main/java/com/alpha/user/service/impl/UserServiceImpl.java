package com.alpha.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alpha.core.tools.RestTemplateTool;
import com.alpha.user.bean.User;
import com.alpha.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private static String url = "http://localhost:8081/getUser/";
	
	@Override
	public List<Map<Object,Object>> getUserByName(String name) {

		List<Map<Object,Object>> results =  RestTemplateTool.getResttemplate().getForObject(url+name, List.class);
		
		for(Map m : results){
			System.out.println(m);
		}
		
		return results;
	}

}
