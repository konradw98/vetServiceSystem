package com.example.vetServiceSystem.repositories;

import com.example.vetServiceSystem.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

    //@Query(value="SELECT * FROM meal WHERE meal.id=?1",nativeQuery = true)
    //    Meal getMealById(int email);

    @Query(value="SELECT * FROM visits WHERE id=?",nativeQuery = true)
    Visit geVisitById(long id);

}
