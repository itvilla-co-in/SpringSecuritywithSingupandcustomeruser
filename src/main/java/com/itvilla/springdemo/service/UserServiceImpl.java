package com.itvilla.springdemo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itvilla.springdemo.dao.FADAO;
import com.itvilla.springdemo.dao.RoleDao;
import com.itvilla.springdemo.entity.UserProfile;
import com.itvilla.springdemo.entity.UserRole;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	

	@Autowired
	private FADAO FADAO;

	@Autowired
	private RoleDao roleDao;
	
//	@Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//	
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Override
	@Transactional
	public void saveUser(UserProfile u) {

		FADAO.saveUser(u);
	}
	
	@Override
	@Transactional
	public Map<String,Boolean> checkUserExists(String username, String email)
	{
		return FADAO.checkUserExists(username, email);
	}
	
	@Override
	@Transactional
	public UserProfile createUser(UserProfile user) {
        //User springuser = new User();
    	UserProfile localUser = FADAO.findByUsername(user.getUsername());
    	System.out.println("success point 2" + localUser);
        if (localUser != null) {
            LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
        } else {
            String encryptedPassword = passwordEncoder.encode(user.getPassword());
            System.out.println("success point 3" + encryptedPassword);
            user.setPassword(encryptedPassword);
            Set<UserRole> userRoles = new HashSet<>();
            userRoles.add(new UserRole(user, roleDao.findByName("ROLE_USER")));
           user.setUserRoles(userRoles);
            FADAO.saveUser(user);
            System.out.println("success point 8");
        }

        return user;
    }

 
}





