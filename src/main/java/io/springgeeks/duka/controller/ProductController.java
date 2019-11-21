package io.springgeeks.duka.controller;

import io.springgeeks.duka.domain.Activity;
import io.springgeeks.duka.domain.CategoryEnum;
import io.springgeeks.duka.domain.Product;
import io.springgeeks.duka.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value="/addProduct",method = RequestMethod.GET)
    public String inputProduct(@ModelAttribute("product") Product product, Model model) {
        List<Activity> statusList = Arrays.asList(Activity.Renting, Activity.Selling);
        List<CategoryEnum> categoryEnumList= Arrays.asList(CategoryEnum.Books,CategoryEnum.clothes,CategoryEnum.Electronics,CategoryEnum.vehicles, CategoryEnum.shoes);
        model.addAttribute("enums",Activity.values());
        model.addAttribute("categories", CategoryEnum.values());
        return "addProducts";
    }

    @RequestMapping(value="/addProduct", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {

        try {
            productService.save(product);


        }catch (Exception up) {
            System.out.println("Transaction Failed!!!");
        }

        return "redirect:/viewProducts";
    }

    @RequestMapping(value="/viewProducts",method = RequestMethod.GET)
    public String listProducts(Model model ) {
        List<Product> list = productService.findAll();
        model.addAttribute("products",  list);
        return "viewProducts";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public  String listProduct(@PathVariable("id") Long id, Product product, Model model) {

        model.addAttribute("products",productService.productById(id));

        return "addProduct";
    }

    //=============================

    @RequestMapping(value = {"/"},method = RequestMethod.GET)
    public String searchProduct(@ModelAttribute("products") Product product, Model model){

        model.addAttribute("products", productService.findAll());

        return "welcome";
    }


    @RequestMapping(value = "/search", method = RequestMethod.GET )
    public String newSearchProduct(@ModelAttribute("searchResults") Product product, @RequestParam("search") String search, Model model){

        model.addAttribute("searchResults", productService.searchResults(search));
        return "searchResults";
    }

}
