package com.itvilla.springdemo.config;

import java.security.SecureRandom;
import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.itvilla.springdemo.service.UserSecurityService;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	// add a reference to our security data source
	
	@Autowired
	private DataSource securityDataSource;
	
	
	
	@Autowired
	private UserSecurityService userSecurityService;
	
//	private static final String SALT = "yellow@theme";
	
	private static final String[] PUBLIC_MATCHERS = {
    		"/resources/**",
    		"/FA/signup",
    		"/FA/home",
    		"/FA/",
    		"/login"
    };

    
	 @Bean
	    RequestFilter requestFilter() {
	        RequestFilter filter = new RequestFilter();
	        return filter;
	    }

	 
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		//http.addFilterBefore(requestFilter(), SessionManagementFilter.class)
		//http.addFilterBefore(requestFilter(), BasicAuthenticationFilter.class)
		//http.addFilterBefore(requestFilter(), ChannelProcessingFilter.class)
		//.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
        //.exceptionHandling()
        //.and()
		http
		.addFilterBefore(requestFilter(), ChannelProcessingFilter.class)
		.exceptionHandling()
		.and()
        .csrf().disable()
        .cors().and()
        .formLogin()
		.loginPage("/FA/home")
		//.loginProcessingUrl("/authenticateTheUser")
		.failureUrl("/FA/home?error")
		.defaultSuccessUrl("/FA/mainpage")
		//.successForwardUrl("/FA/mainpage")
		.permitAll()
		.and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/FA/home?logout").deleteCookies().permitAll();;
		
		//http.httpBasic()
		//.and()
		http
		.authorizeRequests()
		.antMatchers("/FA/mainpage").hasAnyRole("MANAGER", "ADMIN","EMPLOYEE","USER")
		.antMatchers(PUBLIC_MATCHERS).permitAll();

	}
	
   @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
    
	
   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	   auth.authenticationProvider(authenticationProvider());
	   //auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder());
   }
	
   @Bean
   public DaoAuthenticationProvider authenticationProvider() {
       DaoAuthenticationProvider authProvider
         = new DaoAuthenticationProvider();
       authProvider.setUserDetailsService(userSecurityService);
       authProvider.setPasswordEncoder(passwordEncoder());
       return authProvider;
   }
    
   
		
}






