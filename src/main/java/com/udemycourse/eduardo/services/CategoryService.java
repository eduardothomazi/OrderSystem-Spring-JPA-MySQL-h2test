package com.udemycourse.eduardo.services;

import com.udemycourse.eduardo.entities.Category;
import com.udemycourse.eduardo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Optional<Category> findById(Long id){
        return repository.findById(id);
    }
    /*Other way to implement:
        public Category findById(Long id){
        return repository.findById(id).get();}
    */
}
