package com.example.vetServiceSystem.controllers;

import com.example.vetServiceSystem.model.Owner;
import com.example.vetServiceSystem.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class OwnerController {

    private OwnerService ownerService;

    @GetMapping("/owner/{ownerId}")
    public Owner getBookByIsbn(@PathVariable long ownerId) {

        return ownerService.findOwnerById(ownerId);

    }




    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }
}
