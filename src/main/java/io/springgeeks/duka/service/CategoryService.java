package io.springgeeks.duka.service;

import io.springgeeks.duka.domain.Category;

import java.util.List;

public interface CategoryService {
    Category addCategory(Category category);
    List<Category> listCategory();
}
