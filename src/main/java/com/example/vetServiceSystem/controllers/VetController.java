package com.example.vetServiceSystem.controllers;

import com.example.vetServiceSystem.model.Owner;
import com.example.vetServiceSystem.model.Vet;
import com.example.vetServiceSystem.repositories.VetRepository;
import com.example.vetServiceSystem.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class VetController {

    private final VetService vetService;

    @RequestMapping("vets")
    public String listVets(Model model){
        List<Vet> vets=vetService.findAll();

        model.addAttribute("vets",vets);


        return  "vets/index";
    }

    @RequestMapping("/vets/new")
    public String showNewMealForm(Model model){

        Vet vet= new Vet();

        model.addAttribute("vet", vet);

        return "vets/newVet";
    }

    @RequestMapping(value="vets/saveVet")
    public String saveProduct(@ModelAttribute("vet") Vet vet){

        vetService.save(vet);
        return "redirect:/vets";
    }

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }
}
