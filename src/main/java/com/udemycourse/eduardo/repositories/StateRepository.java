package com.udemycourse.eduardo.repositories;

import com.udemycourse.eduardo.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
