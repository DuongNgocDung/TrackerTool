package io.javabrains.trackertool.controllers;

import io.javabrains.trackertool.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusDataService coronaService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("locationStats", this.coronaService.getAllStats());
        return "home";
    }
}
