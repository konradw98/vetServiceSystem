package com.example.vetServiceSystem.repositories;

import com.example.vetServiceSystem.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
}
