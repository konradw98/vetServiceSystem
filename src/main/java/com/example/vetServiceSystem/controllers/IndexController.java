package com.example.vetServiceSystem.controllers;

import com.example.vetServiceSystem.repositories.OwnerRepository;
import com.example.vetServiceSystem.repositories.PetRepository;
import com.example.vetServiceSystem.repositories.VetRepository;
import com.example.vetServiceSystem.repositories.VisitRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    private  final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final VetRepository vetRepository;
    private final VisitRepository visitRepository;


    @RequestMapping("index")
    public String index(Model model){
        int numOfOwners=ownerRepository.countOwners();
        System.out.println("numOfOwners="+numOfOwners);
        int numOfVets=vetRepository.countVets();
        int numOfPets=petRepository.countPets();
        int numOfVisits=visitRepository.countVisit();
        model.addAttribute("owners",numOfOwners);
        model.addAttribute("vets",numOfVets);
        model.addAttribute("pets",numOfPets);
        model.addAttribute("visits",numOfVisits);


        return "index";
    }
    @RequestMapping("/welcome")
    public String welcome(){

        return "welcome";
    }

    public IndexController(OwnerRepository ownerRepository, PetRepository petRepository, VetRepository vetRepository, VisitRepository visitRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.vetRepository = vetRepository;
        this.visitRepository = visitRepository;
    }
}
