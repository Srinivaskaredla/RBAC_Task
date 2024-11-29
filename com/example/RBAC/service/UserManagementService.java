package com.example.RBAC.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.RBAC.entity.*;

public interface UserManagementService {
	
    void saveUser(User user);
    
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    
}