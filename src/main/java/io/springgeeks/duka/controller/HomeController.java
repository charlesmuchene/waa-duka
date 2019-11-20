package io.springgeeks.duka.controller;


import io.springgeeks.duka.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {


    @Autowired
    private ProductService productService;

    @RequestMapping({"/", "/welcome"})
    public String welcome(Model model) {


        model.addAttribute("greeting", "Welcome to the Lone Ranger Company, Kimosabe!!");
        model.addAttribute("tagline", "The one and only place to work, so you can live and play!!");

        return "welcome";
    }

}
