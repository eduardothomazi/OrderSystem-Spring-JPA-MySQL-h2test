package com.udemycourse.eduardo.entities.enums;

public enum ClientType {
    PERSON(1, "Pessoa Física"),
    BUSINESS(2, "Pessoa Jurídica");

    private int code;
    private String description;

    ClientType(int code, String description) {
        this.code =code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static ClientType toEnum(Integer code){
        if (code == null){
            return null;
        }
        for (ClientType x : ClientType.values()){
            if (code.equals(x.getCode())){
                return x;
            }
        }
        throw new IllegalArgumentException("Invalid Id! " + code);
    }
}
