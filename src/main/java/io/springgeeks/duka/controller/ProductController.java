package io.springgeeks.duka.controller;

import io.springgeeks.duka.domain.Activity;
import io.springgeeks.duka.domain.Category;
import io.springgeeks.duka.domain.Product;
import io.springgeeks.duka.service.CategoryService;
import io.springgeeks.duka.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String inputProduct(@ModelAttribute("newProduct") Product product, Model model) {
        List<Activity> statusList = Arrays.asList(Activity.Renting, Activity.Selling);
        model.addAttribute("categories", categoryService.allCategories());
        model.addAttribute("enums",Activity.values());
        return "addProduct";
    }

    @RequestMapping(value = "/product/save", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("newProduct") Product product) {

        List<Category> categories = categoryService.allCategories();
        int index = new Random().nextInt(categories.size() - 1);
        product.setCategory(categories.get(index));
        System.out.println(product);
        try {
            productService.save(product);
        }catch (Exception up) {
            System.out.println("Transaction Failed!!!");
        }
        return "redirect:/welcome";
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
        List<Product> list = productService.allProducts();
        model.addAttribute("products", list);
        return "viewProducts";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Product listProduct(@PathVariable("id") Long id) {
        return productService.productById(id);
    }

    @RequestMapping(value = {"/","/welcome"},method = RequestMethod.GET)
    public String searchProduct(@ModelAttribute("product") Product product,  Model model){
        model.addAttribute("categories", categoryService.allCategories());
        model.addAttribute("products", productService.allProducts());

        return "welcome";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET )
    public String newSearchProduct(@ModelAttribute("searchResults") Product product, @RequestParam("search") String search, Model model){

        model.addAttribute("searchResults", productService.searchResults(search));
        return "searchResults";
    }

    @RequestMapping(value = "/searchByCategory", method = RequestMethod.GET)
    public String searchResultsByCategory(@ModelAttribute("results") Product product, @PathVariable("category_id") Long category_id, Model model){

        model.addAttribute("results", productService.searchProductsByCategoryId(category_id));

        return "searchResults";
    }
}
