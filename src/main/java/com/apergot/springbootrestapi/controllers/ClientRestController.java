package com.apergot.springbootrestapi.controllers;

import com.apergot.springbootrestapi.models.entity.Client;
import com.apergot.springbootrestapi.models.services.InterfaceClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/api")
public class ClientRestController {

    @Autowired
    private InterfaceClientService clientService;

    @GetMapping("/clients")
    public List<Client> index() {
        return clientService.findAll();
    }

    @GetMapping("/clients/{id}")
    public Client show(@PathVariable Long id){
        return clientService.findById(id);
    }

    @PostMapping("/clients")
    @ResponseStatus(HttpStatus.CREATED)
    public Client create(@RequestBody Client client) {
        return clientService.save(client);
    }

    @PutMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client, @PathVariable Long id) {
        Client currentClient = clientService.findById(id);
        currentClient.setFirstname(client.getFirstname());
        currentClient.setLastname(client.getLastname());
        currentClient.setEmail(client.getEmail());
        return clientService.save(currentClient);
    }

    @DeleteMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        clientService.delete(id);
    }

}
