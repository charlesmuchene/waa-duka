package io.springgeeks.duka.service.impl.utils;

import io.springgeeks.duka.domain.Product;

/**
 * Product builder class
 */
public class ProductBuilder {

    private Product product;

    public ProductBuilder() {
        this.product = new Product();
    }

    public ProductBuilder setId(long id) {
        product.setId(id);
        return this;
    }

    public ProductBuilder setPrice(double price) {
        product.setPrice(price);
        return this;
    }

    public Product build() {
        return product;
    }
}
