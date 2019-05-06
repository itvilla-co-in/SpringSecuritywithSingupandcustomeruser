package com.itvilla.springdemo.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.itvilla.springdemo.entity.UserProfile;
import com.itvilla.springdemo.entity.UserRole;

public interface UserService {

	// service methods for the employees that we see on screen
	
	//public List<Employee> getEmployees();
	public void saveUser(UserProfile u);
	//public UserProfile createUser(UserProfile user, Set<UserRole> userRoles);
	public UserProfile createUser(UserProfile user);
	public Map<String,Boolean> checkUserExists(String username, String email);
	//public Employee getEmployee(int theId);
	//public void deleteEmployee(int theId);
	// service methods for the user profile during registration
	//public void saveUserP(myUser myuser);
	
}
