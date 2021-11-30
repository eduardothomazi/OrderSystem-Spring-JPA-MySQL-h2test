package com.udemycourse.eduardo.resources;

import com.udemycourse.eduardo.entities.Client;
import com.udemycourse.eduardo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public ResponseEntity<List<Client>> findAll(){
        return ResponseEntity.ok().body(clientService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Long id){
        Client client = clientService.findById(id);
        return ResponseEntity.ok().body(client);
    }

}
