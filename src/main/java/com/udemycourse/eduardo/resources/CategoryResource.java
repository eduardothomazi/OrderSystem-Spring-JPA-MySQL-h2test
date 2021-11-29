package com.udemycourse.eduardo.resources;

import com.udemycourse.eduardo.entities.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> test(){
        Category cat1 = new Category(1L, "Informatica");
        Category cat2 = new Category(2L, "Escritorio");
        List<Category> categoryList = new ArrayList<>();
        categoryList.addAll(Arrays.asList(cat1, cat2));
        return categoryList;
    }
}
