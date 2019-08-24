package com.alpha.user.service;

import java.util.List;
import java.util.Map;

import com.alpha.user.bean.User;

public interface UserService {
	
	List<Map<Object,Object>> getUserByName(String name);
	
}
