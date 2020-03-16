package com.apergot.springbootrestapi.models.services;

import com.apergot.springbootrestapi.models.dao.InterfaceClientDao;
import com.apergot.springbootrestapi.models.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImp implements InterfaceClientService {

    @Autowired
    private InterfaceClientDao clientDao;
    @Override
    @Transactional(readOnly = true)
    public List<Client> findAll() {
        return (List<Client>) clientDao.findAll();
    }
}
