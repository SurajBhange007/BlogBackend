package com.suraj.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suraj.blog.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Integer>{

}
