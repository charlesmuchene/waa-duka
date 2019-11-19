package io.springgeeks.duka.service;

public interface BiddingService {

    /**
     * Place bid
     * @param productId {@link io.springgeeks.duka.domain.Product} id
     * @param price     Bid price
     */
    void placeBid(long productId, double price);

}
