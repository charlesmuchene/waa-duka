package io.springgeeks.duka.service.impl;

import io.springgeeks.duka.domain.Category;
import io.springgeeks.duka.repository.CategoryRepository;
import io.springgeeks.duka.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> allCategories() {
        return (List<Category>) categoryRepository.findAll();
    }
    @Override
    public Category getCategoryById(long id) {
        return categoryRepository.findOne(id);
    }
    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }
}
