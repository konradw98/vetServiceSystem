package com.example.vetServiceSystem.controllers;

import com.example.vetServiceSystem.model.Owner;
import com.example.vetServiceSystem.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
public class OwnerController {

    private final OwnerService ownerService;

   /* @GetMapping("/owner/{ownerId}")
    public Owner getOwnerById(@PathVariable long ownerId) {
        return ownerService.findById(ownerId);
    }*/


    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }



    @DeleteMapping("/owner/{id}")
    void deleteById(@PathVariable Long id) {
        ownerService.deleteById(id);
    }



    @GetMapping("/owner/{ownerId}")
    public ModelAndView showOwner(@PathVariable Long ownerId) {
        ModelAndView mav = new ModelAndView("/owners/ownerDetails");
        Owner owner= ownerService.findById(ownerId);

        mav.addObject("owner",owner);
        return mav;
    }

   /* @RequestMapping({"owners","owners/index","owners/index/index.html"})
    public String listOwners(Model model){

        model.addAttribute("owners",ownerService.findAll());

        return  "owners/index";
    }*/



    @RequestMapping("owners/find")
    public String findOwners(){
        return "notimplemented";
    }

    @RequestMapping("/find")
    public String findOwners(Model model){

        model.addAttribute("owner", new Owner());
        return "owners/findOwners";
    }

    @GetMapping("/owners")
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




    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }
}
