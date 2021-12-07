package com.udemycourse.eduardo.resources;

import com.udemycourse.eduardo.entities.OrderClass;
import com.udemycourse.eduardo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService service;

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public ResponseEntity<List<OrderClass>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Long id){
        OrderClass order = service.findById(id);
        return ResponseEntity.ok().body(order);
    }

}
