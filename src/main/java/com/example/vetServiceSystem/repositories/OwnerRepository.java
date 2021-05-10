package com.example.vetServiceSystem.repositories;

import com.example.vetServiceSystem.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
