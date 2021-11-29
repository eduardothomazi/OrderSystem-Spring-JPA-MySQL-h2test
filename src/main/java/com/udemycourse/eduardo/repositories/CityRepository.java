package com.udemycourse.eduardo.repositories;

import com.udemycourse.eduardo.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
