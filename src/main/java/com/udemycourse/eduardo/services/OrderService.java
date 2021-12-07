package com.udemycourse.eduardo.services;

import com.udemycourse.eduardo.entities.OrderClass;
import com.udemycourse.eduardo.repositories.OrderRepository;
import com.udemycourse.eduardo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<OrderClass> findAll(){
        return repository.findAll();
    }

    public OrderClass findById(Long id){
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Order not found! Id: "
                + id + " Type: "
                + OrderClass.class.getName()));

    }

}
