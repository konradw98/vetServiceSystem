package com.example.vetServiceSystem.controllers;

import com.example.vetServiceSystem.model.Visit;
import com.example.vetServiceSystem.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class VisitController {
    private VisitService visitService;

    @GetMapping("visit/{visitId}")
    public Visit findVisitById(@PathVariable long visitId){
        return  visitService.findVisitById(visitId);
    }

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }
}
