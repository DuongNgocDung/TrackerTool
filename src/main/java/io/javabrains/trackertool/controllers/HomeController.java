package io.javabrains.trackertool.controllers;

import io.javabrains.trackertool.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusDataService coronaService;

    @GetMapping("/")
    public String home(Model model) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        model.addAttribute("locationStats", this.coronaService.getAllStats());
        model.addAttribute("date", formatter.format(date));
        return "home";
    }
}
