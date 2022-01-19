package com.udemycourse.eduardo.resources.exceptions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<FieldMessage> fieldMessageList = new ArrayList<>();


    public ValidationError(Integer status, String message, Long timeStamp) {
        super(status, message, timeStamp);
    }



    public List<FieldMessage> getErrorMessage() {
        return fieldMessageList;
    }

    public void addError(String fieldName, String message){
        fieldMessageList.add(new FieldMessage(fieldName,message));
    }
}
