package com.example.vetServiceSystem.repositories;


import com.example.vetServiceSystem.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepository extends JpaRepository<Vet, Long> {

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM vets")
    int countVets();
}