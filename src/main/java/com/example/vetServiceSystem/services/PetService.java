package com.example.vetServiceSystem.services;

import com.example.vetServiceSystem.model.Owner;
import com.example.vetServiceSystem.model.Pet;
import com.example.vetServiceSystem.repositories.PetRepository;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    private PetRepository petRepository;

    public Pet findPetById(long petId) {
        return petRepository.findById(petId).get(); //napisac metode w JPA repository, zeby nie uzywac optionala (w innych serwisach tez)
    }

    public void deleteById(Long id){
        petRepository.deleteById(id);
    }
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
}
