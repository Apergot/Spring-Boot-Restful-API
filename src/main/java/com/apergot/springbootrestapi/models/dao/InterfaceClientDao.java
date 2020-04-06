package com.apergot.springbootrestapi.models.dao;

import com.apergot.springbootrestapi.models.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterfaceClientDao extends JpaRepository<Client, Long> {
}
