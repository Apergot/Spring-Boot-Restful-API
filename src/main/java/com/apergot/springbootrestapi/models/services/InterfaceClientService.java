package com.apergot.springbootrestapi.models.services;

import com.apergot.springbootrestapi.models.entity.Client;

import java.util.List;

public interface InterfaceClientService {

    public List<Client> findAll();
    public Client findById(Long id);
    public Client save(Client client);
    public void delete(Long id);
}
