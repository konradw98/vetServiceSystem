package com.example.vetServiceSystem.controllers;

import com.example.vetServiceSystem.model.Pet;
import com.example.vetServiceSystem.services.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PetController {

    private PetService petService;

    @GetMapping("/pet/{petId}")
    public Pet findPetById(@PathVariable long petId){
        return petService.findPetById(petId);
    }

    @DeleteMapping("/pet/{id}")
    void deleteById(@PathVariable Long id) {
        petService.deleteById(id);
    }

    public PetController(PetService petService) {
        this.petService = petService;
    }
}
