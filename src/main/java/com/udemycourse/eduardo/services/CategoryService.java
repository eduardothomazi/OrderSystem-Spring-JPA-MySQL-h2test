package com.udemycourse.eduardo.services;

import com.udemycourse.eduardo.datatransferobjects.CategoryDTO;
import com.udemycourse.eduardo.entities.Category;
import com.udemycourse.eduardo.repositories.CategoryRepository;
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
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Long id){
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Category not found! Id: "
                + id + " Type: "
                + Category.class.getName()));
    }

    public Category insert(Category obj){
        obj.setId(null);
        return repository.save(obj);
    }

    public Category update(Category obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            repository.deleteById(id);

        }catch (DataIntegrityViolationException e){
            throw new DbIntegrity("Could not delete a category with products!");
        }
    }

    public Page<Category> findPage(Integer page, Integer linesPerPage,String direction, String orderBy){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    public Category fromDTO(CategoryDTO objDTO){
        return new Category(objDTO.getId(),objDTO.getName());
    }
}
