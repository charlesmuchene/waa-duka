package io.springgeeks.duka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping({"/", "/welcome"})
    public String welcome(Model model) {

        model.addAttribute("greeting", "Duka");
        model.addAttribute("tagline", "One stop shop");

        return "welcome";
    }

    @RequestMapping("/bid")
    public String bid() {
        return "bid";
    }

}
