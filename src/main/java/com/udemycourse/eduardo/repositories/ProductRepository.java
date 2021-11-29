package com.udemycourse.eduardo.repositories;

import com.udemycourse.eduardo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
