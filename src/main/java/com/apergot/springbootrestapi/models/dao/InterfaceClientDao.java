package com.apergot.springbootrestapi.models.dao;

import com.apergot.springbootrestapi.models.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceClientDao extends CrudRepository<Client, Long> {
}
