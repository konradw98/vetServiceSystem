package com.example.vetServiceSystem.controllers;

import com.example.vetServiceSystem.model.Owner;
import com.example.vetServiceSystem.model.Pet;
import com.example.vetServiceSystem.services.OwnerService;
import com.example.vetServiceSystem.services.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class OwnerController {

    private final OwnerService ownerService;
    private  final PetService petService;





    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }



    /*@DeleteMapping("/owner/{id}")
    void deleteById(@PathVariable Long id) {
        ownerService.deleteById(id);
    }*/


    @RequestMapping("/pets/new/{ownerId}")
    public String addPet(@PathVariable Long ownerId, Model model){
       //dodac model Pet i dodacc id
        Pet pet= new Pet();
        model.addAttribute("pet",pet);
        model.addAttribute("ownerId",ownerId);

        return "pets/newPet";

    }
    @RequestMapping("pets/new/savePet/owner/{ownerId}")
    public String saveOwner(@ModelAttribute("pet") Pet pet, @PathVariable Long ownerId){
        pet.setOwner(ownerService.findById(ownerId));
        petService.savePet(pet);

        return "redirect:/owners/"+ownerId;//+pet.getOwner().getId();
    }


   @RequestMapping("owners/index")
    public String listOwners(Model model){

        model.addAttribute("owners",ownerService.findAll());

        return  "owners/index";
    }

    @RequestMapping("/owners/new")
    public String showNewOwnerForm(Model model){

        Owner owner=new Owner();

        model.addAttribute("owner", owner);

        return "owners/newOwner";
    }

    @RequestMapping(value="owners/saveOwner")
    public String saveOwner(@ModelAttribute("owner") Owner owner){

        ownerService.save(owner);
        return "redirect:/owners/"+owner.getId();
    }


    @RequestMapping("/find")
    public String findOwners(Model model){

        model.addAttribute("owner", new Owner());
        return "owners/findOwners";
    }

    @GetMapping("owners/{ownerId}")
    public ModelAndView showOwner(@PathVariable Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }

    @GetMapping("/ownersFind")
    public String processFindForm(Owner owner, BindingResult result, Model model){
        // allow parameterless GET request for /owners to return all records
        if (owner.getLastName() == null) {
            owner.setLastName(""); // empty string signifies broadest possible search
        }

        // find owners by last name
        List<Owner> results = ownerService.findAllByLastNameLike("%"+ owner.getLastName() + "%");
        for (Owner ow: results) {
            System.out.println(ow.getLastName()); }

        if (results.isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        } else if (results.size() == 1) {
            // 1 owner found
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        } else {
            // multiple owners found
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }
    }


    public OwnerController(OwnerService ownerService, PetService petService) {
        this.ownerService = ownerService;
        this.petService = petService;
    }
}
