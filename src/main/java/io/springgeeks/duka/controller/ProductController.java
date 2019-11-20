package io.springgeeks.duka.controller;

import io.springgeeks.duka.domain.Category;
import io.springgeeks.duka.domain.Product;
import io.springgeeks.duka.service.CategoryService;
import io.springgeeks.duka.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    CategoryService categoryService;

    @RequestMapping(value = {"/"},method = RequestMethod.GET)
    public String searchProduct(@ModelAttribute("products") Product product, Model model){

        model.addAttribute("products", productService.findProducts());

        return "welcome";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET )
    public String newSearchProduct(@ModelAttribute("searchResults") Product product, @RequestParam("search") String search, Model model){

        model.addAttribute("searchResults", productService.searchResults(search));
        return "searchResults";
    }


}
