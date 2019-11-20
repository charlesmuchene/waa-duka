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
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product findByProductNumber(String productId) {
        return productRepository.findByNumber(productId);
    }
    @Override
    public List<Product> allProducts() {
        return (List<Product>) productRepository.findAll();
    }
    @Override
    public Product productById(long id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

}
