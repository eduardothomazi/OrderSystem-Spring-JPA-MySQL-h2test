package com.udemycourse.eduardo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udemycourse.eduardo.entities.enums.PaymentStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer status;

    @JsonIgnore @OneToOne @JoinColumn(name = "order_id") @MapsId
    private OrderClass orderClass;

    public Payment() {
    }

    public Payment(Long id, PaymentStatus status, OrderClass orderClass) {
        this.id = id;
        this.status = (status == null) ? null : status.getId();
        this.orderClass = orderClass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PaymentStatus getStatus() {
        return PaymentStatus.toEnum(status);
    }

    public void setStatus(PaymentStatus status) {
        this.status = status.getId();
    }

    @JsonIgnore
    public OrderClass getOrder() {
        return orderClass;
    }

    public void setOrder(OrderClass orderClass) {
        this.orderClass = orderClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
