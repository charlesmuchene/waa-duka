package io.springgeeks.duka.service;

import io.springgeeks.duka.domain.Product;

public interface BiddingService {

    /**
     * Place bid
     * @param productId {@link io.springgeeks.duka.domain.Product} id
     * @param price     Bid price
     * @return {@link Product} instance
     */
    Product placeBid(long productId, double price);

}
