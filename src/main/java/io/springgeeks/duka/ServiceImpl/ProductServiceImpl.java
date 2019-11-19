package io.springgeeks.duka.ServiceImpl;

import io.springgeeks.duka.domain.Product;
import io.springgeeks.duka.repository.ProductRepository;
import io.springgeeks.duka.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository ProductRepository;

    public List<Product> findAll() {
        return (List<Product>) ProductRepository.findAll();
    }




    public void save(Product product) {
        ProductRepository.save(product);
    }


    public Product findByProductNumber(Long productId) {
        return ProductRepository.findByProductNumber(productId);
    }
}
