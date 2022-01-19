package com.udemycourse.eduardo.datatransferobjects;

import com.udemycourse.eduardo.entities.Client;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class ClientDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    @NotEmpty(message = "This field is mandatory")
    @Length(min = 5,max = 80,message = "Length must be between 5 and 80 characters")
    private String  name;
    @Email
    @NotEmpty(message = "This field is mandatory")
    private String email;

    public ClientDTO() {
    }

    public ClientDTO(Client obj){
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
