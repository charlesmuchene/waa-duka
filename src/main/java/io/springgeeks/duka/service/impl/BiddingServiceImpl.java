package io.springgeeks.duka.service.impl;

import io.springgeeks.duka.domain.Product;
import io.springgeeks.duka.service.BiddingService;
import io.springgeeks.duka.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BiddingServiceImpl implements BiddingService {

    private ProductService productService;

    @Autowired
    public BiddingServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Product placeBid(long productId, double price) {
        Product product = productService.productById(productId);
        if (product == null) return null;

        if (product.getPrice() >= price) return null;

        product.setPrice(price);
        productService.save(product);

        return product;
    }

}
