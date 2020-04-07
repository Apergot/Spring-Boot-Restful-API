package com.apergot.springbootrestapi.models.dao;

import com.apergot.springbootrestapi.models.entity.Client;
import com.apergot.springbootrestapi.models.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InterfaceClientDao extends JpaRepository<Client, Long> {

    @Query("from Region")
    public List<Region> findAllRegions();
}
