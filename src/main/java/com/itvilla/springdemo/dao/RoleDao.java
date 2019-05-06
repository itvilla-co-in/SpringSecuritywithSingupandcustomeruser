package com.itvilla.springdemo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.itvilla.springdemo.entity.*;


public interface RoleDao {
    Role findByName(String name);
}
