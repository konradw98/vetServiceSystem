package com.example.vetServiceSystem.services;

import com.example.vetServiceSystem.model.Owner;
import com.example.vetServiceSystem.model.Visit;
import com.example.vetServiceSystem.repositories.PetRepository;
import com.example.vetServiceSystem.repositories.VisitRepository;
import org.springframework.stereotype.Service;

@Service
public class VisitService {

    private VisitRepository visitRepository;

    public Visit findVisitById(long visitId){
        return visitRepository.findById(visitId).get(); //OPTIONAL OGARNAC
    }

    public void deleteById(Long id){
        visitRepository.deleteById(id);
    }

    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }
}
