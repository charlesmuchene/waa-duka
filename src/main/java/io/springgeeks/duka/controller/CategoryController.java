package io.springgeeks.duka.controller;

import io.springgeeks.duka.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;


}
