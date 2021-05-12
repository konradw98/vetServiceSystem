package com.example.vetServiceSystem.repositories;

import com.example.vetServiceSystem.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
}
