package io.springgeeks.duka.service.impl;

import io.springgeeks.duka.domain.Category;
import io.springgeeks.duka.repository.CategoryRepository;
import io.springgeeks.duka.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImp implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> listCategory(){

        return (List<Category>) categoryRepository.findAll();
    }
}
