package com.alpha.user.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alpha.core.controller.BaseController;
import com.alpha.user.bean.User;
import com.alpha.user.service.UserService;
import com.google.common.collect.Lists;

@RestController
public class UserController extends BaseController {

	
	@Autowired
	private UserService userService;
	
	
	 @RequestMapping(value ="/hello/{name}", method = RequestMethod.GET)
	 public List<Map<Object,Object>> helloUser(@PathVariable String name){
		 
		 List<Map<Object,Object>> uList = userService.getUserByName(name);
	
	     return uList;
	 }
	 
	 @RequestMapping(value ="/getUser/{name}", method = RequestMethod.GET)
	 public List hello(@PathVariable String name){
		 Integer i = 0;
		 List userList =  Lists.newArrayList(new User(i++, name),new User(i++, name),new User(i++, name));
	     return userList;
	 }
	 
}
