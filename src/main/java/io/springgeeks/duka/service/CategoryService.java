package io.springgeeks.duka.service;

import io.springgeeks.duka.domain.Category;

import java.util.List;

public interface CategoryService  {
    List<Category> allCategories();
    Category getCategoryById(long id);
    void createCategory(Category category);

}
