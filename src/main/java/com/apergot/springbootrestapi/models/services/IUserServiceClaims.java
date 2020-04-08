package com.apergot.springbootrestapi.models.services;

import com.apergot.springbootrestapi.models.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserServiceClaims {
    User findByUsername(String username);
}
