package com.itvilla.springdemo.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.logging.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itvilla.springdemo.dao.FADAO;
import com.itvilla.springdemo.dao.RoleDao;
import com.itvilla.springdemo.entity.*;

import com.itvilla.springdemo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	private FADAO fadao;
	
	@Autowired
	private SessionFactory sessionFactory;


	
	@Autowired
	private	UserService userService;
	
	private static final Logger logger = LogManager.getLogger("com.itvilla.springdemo.controller");
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}	
	

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Principal principal, Model model) {
		UserProfile user = fadao.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "profile";
    }
	
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String updateUserProfile(Model model, @Valid @ModelAttribute("user") UserProfile user, BindingResult theBindingResult,Principal principal) {
		UserProfile userlogin = fadao.findByUsername(principal.getName());
		
		Boolean usernameExists=false;
		Boolean emailExists=false;
		
		Map<String,Boolean> map = userService.checkUserExists(user.getUsername(), user.getEmail());
		
		for(Map.Entry m:map.entrySet()){  
			   System.out.println(m.getKey()+" "+m.getValue());
			   if (m.getKey().toString() == "username")
				   {
				   model.addAttribute("usernameExists", m.getValue());
				   usernameExists = (Boolean) m.getValue();
				   if (userlogin.getUsername().equals(user.getUsername()))
				   	{
					   usernameExists = false;
				   	}
				   }
			   if (m.getKey().toString() == "email")
			   {
			   model.addAttribute("emailExists", m.getValue());
			   emailExists = (Boolean) m.getValue();
			   if (userlogin.getEmail().equals(user.getEmail()))
			   	{
				   emailExists = false;
			   	}
			   }
			  }  
		
		if(usernameExists || emailExists || theBindingResult.hasErrors())
		{
			return "profile";
		}
		else
		{
			userlogin.setFirstName(user.getFirstName());
			userlogin.setLastName(user.getLastName());
			userlogin.setEmail(user.getEmail());
			userlogin.setPhone(user.getPhone());
			userService.saveUser(userlogin);
            return "redirect:/FA/mainpage";
		}
		

    }

    
	
}










