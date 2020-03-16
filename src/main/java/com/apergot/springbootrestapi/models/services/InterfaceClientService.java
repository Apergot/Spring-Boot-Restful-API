package com.apergot.springbootrestapi.models.services;

import com.apergot.springbootrestapi.models.entity.Client;

import java.util.List;

public interface InterfaceClientService {

    public List<Client> findAll();
}
