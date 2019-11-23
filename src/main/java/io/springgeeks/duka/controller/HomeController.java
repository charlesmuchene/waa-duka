package io.springgeeks.duka.controller;

import io.springgeeks.duka.util.ResourceNotFound;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping({"/", "/welcome"})
    public String welcome(Model model) {

        model.addAttribute("greeting", "Duka");
        model.addAttribute("tagline", "One stop shop");

        return "welcome";
    }

    @RequestMapping(value = "/{view}")
    public String jspView(@PathVariable String view) {
        if(view.equalsIgnoreCase("bid")) {
            return "bid";
        } else if (view.equalsIgnoreCase("home")) {
            return "dashboard";
        } else {
            throw new ResourceNotFound();
        }
    }

}
