package com.example.vetServiceSystem.controllers;

import com.example.vetServiceSystem.model.Owner;
import com.example.vetServiceSystem.model.Pet;
import com.example.vetServiceSystem.services.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PetController {

    private PetService petService;

    @GetMapping("/pet/{petId}")
    public Pet findPetById(@PathVariable long petId){
        return petService.findPetById(petId);
    }

    @PostMapping("/pets")
    Pet newPet(@RequestBody Pet newPet) {
        return petService.savePet(newPet);
    }

    @DeleteMapping("/pet/{id}")
    void deleteById(@PathVariable Long id) {
        petService.deleteById(id);
    }

    @GetMapping("/pets/")
    public List<Pet> getPets(){
        return  petService.findAll();
    }

    public PetController(PetService petService) {
        this.petService = petService;
    }
}
