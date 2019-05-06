package com.itvilla.springdemo.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itvilla.springdemo.dao.FADAO;
import com.itvilla.springdemo.dao.RoleDao;

import com.itvilla.springdemo.entity.UserProfile;
import com.itvilla.springdemo.entity.UserRole;
import com.itvilla.springdemo.service.UserService;

@Controller
@RequestMapping("/FA")
public class FAHomeController {

	// need to inject our employee service
	@Autowired
	private UserService userService;
	
	@Autowired
	private FADAO fadao;
	
	
	@Autowired
	private RoleDao roleDao;
	


	
	private static final Logger logger = LogManager.getLogger("com.itvilla.springdemo.controller");
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}	
	
	@RequestMapping("/")
	public String home(Model theModel, Principal principal) {
			
		return "fahome";
	}
	
	@RequestMapping("/home")
	public String showloginhome(Model theModel, Principal principal) {
			
		return "fahome";
	}
	
	
	@GetMapping("/signup")
	public String showsingnupform(Model theModel) {
		
		// create model attribute to bind form data
		UserProfile u = new UserProfile();
		
		theModel.addAttribute("user", u);
		
		return "signup";
	}

	@PostMapping("/signup")
	public String saveEmployee(Model model, @Valid @ModelAttribute("user") UserProfile user, BindingResult theBindingResult) {
		Boolean usernameExists=false;
		Boolean emailExists=false;

		Map<String,Boolean> map = userService.checkUserExists(user.getUsername(), user.getEmail());
		
		for(Map.Entry m:map.entrySet()){  
			   System.out.println(m.getKey()+" "+m.getValue());
			   if (m.getKey().toString() == "username")
				   {
				   model.addAttribute("usernameExists", m.getValue());
				   usernameExists = (Boolean) m.getValue();
				   }
			   if (m.getKey().toString() == "email")
			   {
			   model.addAttribute("emailExists", m.getValue());
			   emailExists = (Boolean) m.getValue();
			   }
			  }  
		
		if(usernameExists || emailExists || theBindingResult.hasErrors())
		{
			return "signup";
		}
		else
		{


            userService.createUser(user);
            return "redirect:/FA/home";
		}
		
	}

	@RequestMapping("/mainpage")
	public String mainpage(Principal principal, Model model) {
		System.out.println("11111");
		if (principal == null)
		{
			System.out.println("principal is null in mainpage ...........");
		}
		if (principal instanceof UserDetails) {

			  String username = ((UserDetails)principal).getUsername();
			  System.out.println(" inside loop 1 " + username);

			} else {

				System.out.println(" inside loop 2 ");
                String username = principal.getName();
	
			}
		System.out.println("pname " + principal.getName());
		System.out.println("pclass" + principal.getClass());
		UserProfile user = fadao.findByUsername(principal.getName());

        
		return "mainpage";
	}

	
	
	}










