package com.itvilla.springdemo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itvilla.springdemo.entity.Role;
import com.itvilla.springdemo.entity.UserProfile;

@Repository
public class FADAOImpl implements FADAO {
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveUser(UserProfile u) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(u);
		
	}
	
		
	@Override
	public Map<String,Boolean> checkUserExists(String username, String email)
	{
		Map<String,Boolean> map=new HashMap<String,Boolean>();
		Session currentSession = sessionFactory.getCurrentSession();
		
		String hql1 = "FROM UserProfile U WHERE U.email = :email";
		Query query1 = currentSession.createQuery(hql1);
		query1.setParameter("email", email);
		if (query1.list().isEmpty())
		{
			System.out.println("email does not exists");
			map.put("email", false);
			//return false;
		}
		else
		{
			System.out.println("email does not exists");
			map.put("email", true);
			//return true;
		}
		
	
		
		String hql = "FROM UserProfile U WHERE U.username = :username";
		Query query = currentSession.createQuery(hql);
		query.setParameter("username", username);
		if (query.list().isEmpty())
		{
			System.out.println("username does not exists");
			map.put("username", false);
			//return false;
		}
		else
		{
			System.out.println("username does not exists");
			map.put("username", true);
			//return true;
		}
		
		
		
	
		return map;
			
	}
	

	
	@Override
	@Transactional
	public UserProfile findByUsername(String username)
	{
		//Map<String,Boolean> map=new HashMap<String,Boolean>();
		Session currentSession = sessionFactory.getCurrentSession();
		String hql = "FROM UserProfile U WHERE U.username = :username";
		Query query = currentSession.createQuery(hql);
		query.setParameter("username", username);
		List<UserProfile> p = query.getResultList();
		UserProfile utemp = null;
		 for (UserProfile user : p) { 		      
	            	utemp = user;	
	      }
		return utemp;
			
	}
	
	
	


	


}











