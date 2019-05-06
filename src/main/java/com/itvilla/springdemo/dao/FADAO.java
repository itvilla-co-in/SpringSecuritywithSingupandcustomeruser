package com.itvilla.springdemo.dao;

import java.util.List;
import java.util.Map;

import com.itvilla.springdemo.entity.UserProfile;

public interface FADAO {

	
	public void saveUser(UserProfile u);
	public Map<String,Boolean> checkUserExists(String username, String email);
	UserProfile findByUsername(String username);
		
}
