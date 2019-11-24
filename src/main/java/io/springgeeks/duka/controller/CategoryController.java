package io.springgeeks.duka.controller;

import io.springgeeks.duka.domain.Category;
import io.springgeeks.duka.domain.Product;
import io.springgeeks.duka.service.CategoryService;
import io.springgeeks.duka.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    ProductService productService;

    @RequestMapping("/{category_id}")
    public String listCatProd(@PathVariable long category_id, @ModelAttribute("productsPerCategory") Product product){

         productService.searchProductsByCategoryId(category_id);

         return "catlist";

    }
}
