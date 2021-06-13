package com.example.vetServiceSystem.repositories;

import com.example.vetServiceSystem.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM pets")
    int countPets();
}
