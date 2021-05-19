package com.example.vetServiceSystem.services;

import com.example.vetServiceSystem.model.Owner;
import com.example.vetServiceSystem.model.Pet;
import com.example.vetServiceSystem.model.Visit;
import com.example.vetServiceSystem.repositories.PetRepository;
import com.example.vetServiceSystem.repositories.VisitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitService {

    private VisitRepository visitRepository;

    public Visit findVisitById(long visitId) {
        return visitRepository.geVisitById(visitId); //OPTIONAL OGARNAC
    }

    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }

    public Visit saveVisit(Visit visit) {
        return visitRepository.save(visit);
    }

    public List<Visit> findAll() {
        return visitRepository.findAll();
    }

    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }
}
