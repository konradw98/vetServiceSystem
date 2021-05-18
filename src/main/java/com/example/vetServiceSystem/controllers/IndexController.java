package com.example.vetServiceSystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "index", "index.html"})
    public String index(){

        return "index";
    }
    @RequestMapping("/welcome")
    public String welcome(){

        return "welcome";
    }
}
