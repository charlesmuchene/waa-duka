package io.springgeeks.duka.repository;

import io.springgeeks.duka.domain.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getAll();

    void save(Product product);

    Product getOne(Long id);
}
