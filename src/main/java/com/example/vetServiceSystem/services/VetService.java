package com.example.vetServiceSystem.services;

import com.example.vetServiceSystem.model.Pet;
import com.example.vetServiceSystem.model.Vet;
import com.example.vetServiceSystem.repositories.VetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VetService {
    VetRepository vetRepository;

    public Vet save(Vet vet){
        return  vetRepository.save(vet);
    }

    public List<Vet> findAll() {
        return vetRepository.findAll();
    }

    public VetService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }
}
