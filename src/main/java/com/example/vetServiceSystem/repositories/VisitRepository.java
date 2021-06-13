package com.example.vetServiceSystem.repositories;

import com.example.vetServiceSystem.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {



    @Query(value="SELECT * FROM visits WHERE id=?",nativeQuery = true)
    Visit geVisitById(long id);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM visits")
    int countVisit();

}
