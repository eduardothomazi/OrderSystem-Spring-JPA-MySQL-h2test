package com.udemycourse.eduardo.repositories;

import com.udemycourse.eduardo.entities.OrderClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderClass, Long> {
}
