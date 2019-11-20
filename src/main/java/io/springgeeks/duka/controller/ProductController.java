package io.springgeeks.duka.controller;

import io.springgeeks.duka.domain.Product;
import io.springgeeks.duka.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public String inputProduct(Model model) {
        return "addProduct";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String saveProduct(Product product) {
        productService.save(product);
        return "ProductDetails";
    }

    @RequestMapping(value = "/viewProducts", method = RequestMethod.GET)
    public String listProducts(Model model) {
        List<Product> list = productService.findAll();
        model.addAttribute("products", list);
        return "viewProducts";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Product listProduct(@PathVariable("id") Long id) {
        return productService.findOne(id);
    }

}
