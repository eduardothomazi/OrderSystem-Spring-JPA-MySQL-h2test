package com.udemycourse.eduardo.entities;

import com.udemycourse.eduardo.entities.enums.PaymentStatus;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class ProgrammedPayment extends Payment{
    static final long serialVersionUID = 1L;

    private Date dueDate;
    private Date paymentDate;


    public ProgrammedPayment() {
    }

    public ProgrammedPayment(Long id, PaymentStatus status, OrderClass orderClass, Date dueDate, Date paymentDate) {
        super(id, status, orderClass);
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
