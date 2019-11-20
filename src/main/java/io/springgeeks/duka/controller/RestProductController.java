package io.springgeeks.duka.controller;

import io.springgeeks.duka.domain.Product;
import io.springgeeks.duka.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/listproducts")
public class RestProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/listproducts")
    public List<Product> searchProject(){

        return productService.findProducts();
    }

}
