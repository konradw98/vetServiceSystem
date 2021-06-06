package com.example.vetServiceSystem.controllers;

import com.example.vetServiceSystem.model.Drug;
import com.example.vetServiceSystem.repositories.DrugRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DrugController {

    private  final DrugRepository drugRepository;

    @RequestMapping("/drugs")
    public String showAlldrugs(Model model){
        List<Drug> drugList=drugRepository.findAll();
        model.addAttribute("drugs",drugList);
        return  "drugs/drugsList";
    }

    public DrugController(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }
}
