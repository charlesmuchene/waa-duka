package io.springgeeks.duka.ServiceImpl;

import io.springgeeks.duka.domain.Product;
import io.springgeeks.duka.repository.ProductRepository;
import io.springgeeks.duka.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository ProductRepository;
    @Override
    public List<Product> getAll() {
        return ProductRepository.getAll();
    }

    @Override
    public void save(Product product) {
        ProductRepository.save(product);
    }

    @Override
    public Product getOne(Long id) {
        return ProductRepository.getOne(id);
    }
}
