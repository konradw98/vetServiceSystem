package com.example.vetServiceSystem.controllers;

import com.example.vetServiceSystem.model.Owner;
import com.example.vetServiceSystem.model.Visit;
import com.example.vetServiceSystem.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.util.List;

@RestController
public class VisitController {
    private VisitService visitService;

    @GetMapping("visit/{visitId}")
    public Visit findVisitById(@PathVariable long visitId) {
        return visitService.findVisitById(visitId);
    }

    @DeleteMapping("/visit/{id}")
    void deleteById(@PathVariable Long id) {
        visitService.deleteById(id);
    }

    @PostMapping("/visits")
    Visit newVisit(@RequestBody Visit newVisit) {
        return visitService.saveVisit(newVisit);
    }

    @GetMapping("/visists/")
    public List<Visit> getVisitss() {
        return visitService.findAll();

    }

    @InitBinder
    public void dataBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");

        dataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException{
                setValue(LocalDate.parse(text));
            }
        });
    }

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }
}
