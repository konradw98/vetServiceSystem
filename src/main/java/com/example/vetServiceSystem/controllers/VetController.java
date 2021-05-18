package com.example.vetServiceSystem.controllers;

import com.example.vetServiceSystem.model.Vet;
import com.example.vetServiceSystem.repositories.VetRepository;
import com.example.vetServiceSystem.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class VetController {

    private final VetService vetService;

    @RequestMapping({"vets","vets/index","vets/index/index.html"})
    public String listVets(Model model){
        List<Vet> vets=vetService.findAll();
        for (Vet vet:
             vets) {
            System.out.println(vet);
        }
        model.addAttribute("vets",vets);


        return  "vets/index";
    }


    public VetController(VetService vetService) {
        this.vetService = vetService;
    }
}
