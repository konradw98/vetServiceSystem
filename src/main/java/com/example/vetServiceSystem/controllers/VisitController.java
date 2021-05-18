package com.example.vetServiceSystem.controllers;

import com.example.vetServiceSystem.model.Owner;
import com.example.vetServiceSystem.model.Visit;
import com.example.vetServiceSystem.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }
}
