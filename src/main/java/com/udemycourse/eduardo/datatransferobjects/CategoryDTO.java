package com.udemycourse.eduardo.datatransferobjects;

import com.udemycourse.eduardo.entities.Category;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    @NotEmpty(message = "This value cannot be empty!")
    @Length(min = 5,max = 80,message = "Must be between 5 and 80 characters")
    private String name;

    public CategoryDTO() {
    }

    public CategoryDTO(Category obj) {
        id = obj.getId();
        name = obj.getName();
    }

    public CategoryDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
