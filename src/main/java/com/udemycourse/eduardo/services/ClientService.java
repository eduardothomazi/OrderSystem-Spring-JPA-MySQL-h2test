package com.udemycourse.eduardo.services;

import com.udemycourse.eduardo.datatransferobjects.ClientDTO;
import com.udemycourse.eduardo.entities.Client;
import com.udemycourse.eduardo.repositories.ClientRepository;
import com.udemycourse.eduardo.services.exceptions.DbIntegrity;
import com.udemycourse.eduardo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Client not found! Id: "
                + id + " Type: "
                + Client.class.getName()));
    }
    public Client insert(Client obj){
        obj.setId(null);
        return repository.save(obj);
    }

    public Client update(Client obj) {
        Client newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            repository.deleteById(id);

        }catch (DataIntegrityViolationException e){
            throw new DbIntegrity("Could not delete a client with orders!");
        }
    }

    public Page<Client> findPage(Integer page, Integer linesPerPage, String direction, String orderBy){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    public Client fromDTO(ClientDTO objDTO){
        return new Client(objDTO.getId(),objDTO.getName(),objDTO.getEmail(),null,null);
    }

    private void updateData(Client newObj, Client obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }
}
