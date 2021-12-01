package com.udemycourse.eduardo.entities;

import com.udemycourse.eduardo.entities.enums.PaymentStatus;

import javax.persistence.Entity;


@Entity
public class CardPayment extends Payment{
    static final long serialVersionUID = 1L;

    private Integer installments;

    public CardPayment() {
    }

    public CardPayment(Long id, PaymentStatus status, OrderClass orderClass, Integer installments) {
        super(id, status, orderClass);
        this.installments = installments;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

}
