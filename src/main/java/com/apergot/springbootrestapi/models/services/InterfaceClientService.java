package com.apergot.springbootrestapi.models.services;

import com.apergot.springbootrestapi.models.entity.Client;
import com.apergot.springbootrestapi.models.entity.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface InterfaceClientService {

    public List<Client> findAll();
    public Page<Client> findAll(Pageable pageable);
    public Client findById(Long id);
    public Client save(Client client);
    public void delete(Long id);
    public List<Region> findAllRegions();
}
