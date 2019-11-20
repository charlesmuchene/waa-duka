package io.springgeeks.duka.service.impl;

import io.springgeeks.duka.domain.Product;
import io.springgeeks.duka.repository.ProductRepository;
import io.springgeeks.duka.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public List<Product> searchResults(String search) {
        return productRepository.searchResults(search);
    }
}
