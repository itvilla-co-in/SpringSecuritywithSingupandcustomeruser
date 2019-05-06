package com.itvilla.springdemo.service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.itvilla.springdemo.dao.*;
import com.itvilla.springdemo.entity.UserProfile;


@Service
public class UserSecurityService implements UserDetailsService {

    /** The application logger */
    private static final Logger LOG = LoggerFactory.getLogger(UserSecurityService.class);

    @Autowired
    private FADAO fadao;
 
    @Override
    public UserDetails loadUserByUsername(String username) {
    	System.out.println("in load by username " + username);
        //User user = fadao.findBySpringUsername(username); 
    	UserProfile user = fadao.findByUsername(username); 
        
        		//userRepository.newfindByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        System.out.println("found user in loadby usrname" + user.getUsername());
        System.out.println("found user in loadby usrname" + user.getPassword());
         String[] authorities = user.getAuthorities()
            .stream().map(a -> a.getAuthority()).toArray(String[]::new);
         
        String urole = null;
        Collection<GrantedAuthority> authorities3 = new HashSet<>();
        for (String string : authorities) {
        	System.out.println("autoritis" + string);
        	authorities3.add(new SimpleGrantedAuthority(string));
		}
        UserDetails u = (UserDetails) new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),true,true,true,true,authorities3);
        //return new org.springframework.security.core.userdetails.User(
        //		user.getUsername(),user.getPassword(),true,true,true,true,authorities3);
        return u;
    }
    
    
    
    /*
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	System.out.println("Hello Usersecurity serivce are we in ..." + username);
    	
        //UserProfile user = fadao.findByUsername(username);
    	User user = fadao.findBySpringUsername(username);
    	//UserBuilder builder = null;
        //System.out.println("Hello am i getting the user " + user.toString());
        if (null == user) 
        {
            LOG.warn("Username {} not found", username);
            throw new UsernameNotFoundException("Username " + username + " not found");
        }
        System.out.println("Hello am i getting the user " + user.toString());
        //return buildUserForAuthentication(user, authorities);
        
        System.out.println("uname" + user.getUsername());
        System.out.println("passwrd" + user.getPassword());
        System.out.println("autorities" + user.getAuthorities());
        System.out.println("" + user.isAccountNonExpired());
        System.out.println("" + user.isAccountNonLocked());
        System.out.println("" + user.isCredentialsNonExpired());
        System.out.println("enables" + user.isEnabled());
        //builder.username(user.getUsername());
        //builder = org.springframework.security.core.userdetails.User.withUsername(username);
        
        //builder.disabled(user.isEnabled());
        //builder.password(user.getPassword());
        //String[] authorities = user.getAuthorities()
        //    .stream().map(a -> a.getAuthority()).toArray(String[]::new);
        //builder.authorities(authorities);
        //System.out.println("autoritis" + authorities.toString());
        //for (String string : authorities) {
        //	System.out.println("autoritis" + string);
		//}
        
        return user;
    }
    */
        
}
