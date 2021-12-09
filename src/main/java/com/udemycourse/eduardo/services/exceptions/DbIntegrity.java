package com.udemycourse.eduardo.services.exceptions;

public class DbIntegrity extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DbIntegrity(String message) {
        super(message);
    }

    public DbIntegrity(String message, Throwable cause) {
        super(message, cause);
    }
}
