package com.example.vetServiceSystem.controllers;

import com.example.vetServiceSystem.model.Owner;
import com.example.vetServiceSystem.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class OwnerController {

    private OwnerService ownerService;

    @GetMapping("/owner/{ownerId}")
    public Owner getOwnerById(@PathVariable long ownerId) {

        return ownerService.findOwnerById(ownerId);

    }

    @PostMapping("/owners")
    Owner newOwner(@RequestBody Owner newOwner) {
        return ownerService.saveOwner(newOwner);
    }

    @DeleteMapping("/owner/{id}")
    void deleteById(@PathVariable Long id) {
        ownerService.deleteById(id);
    }

    @GetMapping("/owners/")
    public List<Owner> getOwners() {
        return ownerService.findAll();
    }

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }
}
