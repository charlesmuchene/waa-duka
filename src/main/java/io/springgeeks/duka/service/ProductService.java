package io.springgeeks.duka.service;

import io.springgeeks.duka.domain.Product;

import java.util.List;

public interface ProductService {

    //public Product findByProductNumber(String productId);

    public List<Product> findAll();

    public Product productById(long id);

    void save(Product product);
    List<Product> searchResults(String search);
}
