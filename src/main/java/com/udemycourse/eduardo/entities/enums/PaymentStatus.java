package com.udemycourse.eduardo.entities.enums;

public enum PaymentStatus {
    PENDENT(1),
    PAYED(2),
    CANCELED(3);

    private int id;

    PaymentStatus(Integer id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static PaymentStatus toEnum(Integer code){
        if (code == null){
            return null;
        }
        for (PaymentStatus x : PaymentStatus.values()){
            if (code.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Invalid id! Id: " + code);
    }
}
