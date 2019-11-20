package io.springgeeks.duka.service;


import io.springgeeks.duka.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product addProduct(Product product);
    List<Product> findProducts();
    List<Product> searchResults(String search);

}
