package io.springgeeks.duka.service;

import io.springgeeks.duka.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    Product findOne(long productId);

}
