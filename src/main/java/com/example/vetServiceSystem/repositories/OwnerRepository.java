package com.example.vetServiceSystem.repositories;

import com.example.vetServiceSystem.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    @Query("SELECT DISTINCT owner FROM Owner owner left join fetch owner.pets WHERE owner.lastName LIKE :lastName%")
    @Transactional(readOnly = true)
    List<Owner> findByLastName(@Param("lastName") String lastName);
}
