package io.springgeeks.duka.service;

import io.springgeeks.duka.domain.Product;

import java.util.List;

public interface ProductService {

    public Product findByProductNumber(String productId);

    public Product findByProductSerialNumber(String serialNumber);

    public List<Product> allProducts();

    public Product productById(long id);

    public Product save(Product product);

    List<Product> searchResults(String search);

    List<Product> searchProductsByCategoryId(Long category_id);
}
