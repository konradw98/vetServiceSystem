package com.example.vetServiceSystem.controllers;

import com.example.vetServiceSystem.repositories.OwnerRepository;
import com.example.vetServiceSystem.repositories.PetRepository;
import com.example.vetServiceSystem.repositories.VetRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    
    @RequestMapping("index")
    public String index(){

        return "index";
    }
    @RequestMapping("/welcome")
    public String welcome(){

        return "welcome";
    }
}
