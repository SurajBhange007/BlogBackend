package com.suraj.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.suraj.blog.dao.UserRepo;
import com.suraj.blog.entity.User;
import com.suraj.blog.exceptions.APIException;
import com.suraj.blog.exceptions.ResourceNotFoundException;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepo userRepo;
	 	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepo.findByEmail(username).orElseThrow(()-> new APIException("User Not Found!!! Please Enter Valid Username."));
		return user;
	}

}
