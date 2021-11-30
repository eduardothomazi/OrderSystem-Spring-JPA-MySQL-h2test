package com.udemycourse.eduardo.services;

import com.udemycourse.eduardo.entities.Category;
import com.udemycourse.eduardo.entities.Client;
import com.udemycourse.eduardo.repositories.ClientRepository;
import com.udemycourse.eduardo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    public List<Client> findAll(){
        return repository.findAll();
    }

    public Client findById(Long id){
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Category not found! Id: "
                + id.toString() + " Type: "
                + Category.class.getName()));
    }
}
