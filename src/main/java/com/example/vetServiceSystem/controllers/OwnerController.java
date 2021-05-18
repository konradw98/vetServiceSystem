package com.example.vetServiceSystem.controllers;

import com.example.vetServiceSystem.model.Owner;
import com.example.vetServiceSystem.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
public class OwnerController {

    private final OwnerService ownerService;

    @GetMapping("/owner/{ownerId}")
    public Owner getOwnerById(@PathVariable long ownerId) {
        return ownerService.findById(ownerId);
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

   /* @GetMapping("/owner1/{ownerId}")
    public ModelAndView showOwner(@PathVariable Long ownerId) {
        ModelAndView mav = new ModelAndView("/owners/ownerDetails");
        Owner owner= ownerService.findById(ownerId);

        mav.addObject("owner",owner);
        return mav;
    }*/

    @RequestMapping({"owners","owners/index","owners/index/index.html"})
    public String listOwners(Model model){

        model.addAttribute("owners",ownerService.findAll());

        return  "owners/index";
    }

    @RequestMapping("owners/find")
    public String findOwners(){
        return "notimplemented";
    }




    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }
}
