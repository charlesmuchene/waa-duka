package io.springgeeks.duka.controller;

import io.springgeeks.duka.domain.Product;
import io.springgeeks.duka.service.ProductService;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class ProductController {
    private ProductService productService;

    @RequestMapping(value="/addProduct",method = RequestMethod.GET)
    public String inputProduct(Model model) {
        return "addProduct";
    }

    @RequestMapping(value="/addProduct", method = RequestMethod.POST)
    public String saveProduct(Product product ) {
        productService.save(product);
        return "ProductDetails";
    }

    @RequestMapping(value="/viewProducts",method = RequestMethod.GET)
    public String listProducts(Model model ) {
        List<Product> list = productService.getAll();
        model.addAttribute("products",  list);
        return "viewProducts";
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public @ResponseBody
    Product listProduct(@PathVariable("id") Long id) {
        Product product = productService.getOne(id);
        return product;
    }

}
