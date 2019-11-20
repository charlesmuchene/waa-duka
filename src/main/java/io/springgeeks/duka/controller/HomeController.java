package io.springgeeks.duka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping({"/", "/welcome"})
    public String welcome(Model model) {

        model.addAttribute("greeting", "Welcome to the Lone Ranger Company, Kimosabe!!");
        model.addAttribute("tagline", "The one and only place to work, so you can live and play!!");

        return "welcome";
    }

    @RequestMapping("/bid")
    public String bid() {
        return "bid";
    }

}
