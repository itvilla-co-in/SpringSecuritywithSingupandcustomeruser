package com.itvilla.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itvilla.springdemo.entity.*;

@Repository
public class RoleDaoimpl implements  RoleDao {
    
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Role findByName(String name) {
    	
		Session currentSession = sessionFactory.getCurrentSession();
		String hql = "FROM Role p WHERE p.name = :name";
		Query query = currentSession.createQuery(hql);
		query.setParameter("name", name);
		Role rtemp = null;
		List<Role> p = query.getResultList();
		 for (Role role : p) { 		      
	            	rtemp = role;	
	      }
		return rtemp;

	}
}
