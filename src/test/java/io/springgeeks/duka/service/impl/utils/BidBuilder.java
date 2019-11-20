package io.springgeeks.duka.service.impl.utils;

import io.springgeeks.duka.domain.Bid;
import io.springgeeks.duka.domain.Product;

/**
 * {@link io.springgeeks.duka.domain.Bid} builder
 */
public class BidBuilder {

    private Bid bid;

    public BidBuilder() {
        this.bid = new Bid();
    }

    public BidBuilder from(Product product) {
        bid.setProductId(product.getId());
        return this;
    }

    public BidBuilder setBid(double price) {
        bid.setPrice(price);
        return this;
    }

    public Bid build() {
        return bid;
    }
}
