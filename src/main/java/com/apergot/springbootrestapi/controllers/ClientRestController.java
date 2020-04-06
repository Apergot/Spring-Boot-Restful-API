package com.apergot.springbootrestapi.controllers;

import com.apergot.springbootrestapi.models.entity.Client;
import com.apergot.springbootrestapi.models.services.InterfaceClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;


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

    @GetMapping("/clients/page/{page}")
    public Page<Client> index(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page,4);
        return clientService.findAll(pageable);
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<?> show(@PathVariable Long id){
        Client client = null;
        Map<String, Object> map = new HashMap<>();
        try {
            client = clientService.findById(id);
        } catch (DataAccessException e) {
            map.put("message", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
        if (client == null) {
            map.put("message", "Client id ".concat(id.toString()).concat("does not exists"));
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(client, HttpStatus.OK);

    }

    @PostMapping("/clients")
    public ResponseEntity<?> create(@Valid @RequestBody Client client, BindingResult result) {

        Client createdClient = null;
        Map<String, Object> map = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = new ArrayList<>();
            for (FieldError err: result.getFieldErrors()) {
                errors.add(err.getDefaultMessage());
            }
            map.put("error", errors);
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }

        try {
            createdClient = clientService.save(client);
        } catch (DataAccessException e) {
            map.put("message", "Error inserting into database");
            map.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        map.put("message", "Client has been created successfully");
        map.put("client", createdClient);
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Client client, @PathVariable Long id, BindingResult result) {

        Client currentClient = clientService.findById(id);
        Map<String, Object> map = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> err.getDefaultMessage())
                    .collect(Collectors.toList());
            map.put("error", errors);
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }

        if (currentClient == null) {
            map.put("message", "Could not edit client with id ".concat(id.toString()).concat(" this does not exists"));
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }

        Client updatedClient = null;
        try {
            currentClient.setFirstname(client.getFirstname());
            currentClient.setLastname(client.getLastname());
            currentClient.setEmail(client.getEmail());
            currentClient.setCreateAt(new Date());
            updatedClient = clientService.save(currentClient);
        } catch (DataAccessException e) {
            map.put("message", "Error updating client data");
            map.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        map.put("message", "client updated successfully");
        map.put("client", updatedClient);
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Map<String, Object> map = new HashMap<>();
        try {
            clientService.delete(id);
        } catch (DataAccessException e) {
            map.put("message", "Error deleting user");
            map.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        map.put("message", "client deleted successfully");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping("/clients/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file, @RequestParam("id") Long id){
        Map<String, Object> map = new HashMap<>();
        Client client = clientService.findById(id);

        if ( !file.isEmpty()) {
            String filename = UUID.randomUUID().toString()+ "_" +file.getOriginalFilename().replace(" ", "");
            Path filePath = Paths.get("uploads").resolve(filename).toAbsolutePath();
            System.out.println(filePath.toString());
            try {
                Files.copy(file.getInputStream(), filePath);
            } catch (IOException e) {
                map.put("message", "error while uploading the image");
                map.put("error", e.getMessage().concat(":").concat(e.getCause().getMessage()));
                return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            client.setImage(filename);
            clientService.save(client);
            map.put("client", client);
            map.put("message", "image " + filename + " uploaded successfully!");
        }

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }
}
