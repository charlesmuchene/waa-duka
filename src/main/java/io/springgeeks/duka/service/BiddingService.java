package io.springgeeks.duka.service;

import io.springgeeks.duka.domain.Bid;
import io.springgeeks.duka.domain.Product;

public interface BiddingService {

    /**
     * Place bid
     * @param bid given {@link Bid}
     * @return {@link Product} instance
     */
    Product placeBid(Bid bid);

}
