package com.apergot.springbootrestapi.models.dao;

import com.apergot.springbootrestapi.models.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
