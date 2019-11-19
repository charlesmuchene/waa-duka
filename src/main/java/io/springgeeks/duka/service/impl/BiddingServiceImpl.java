package io.springgeeks.duka.service.impl;

import io.springgeeks.duka.service.BiddingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BiddingServiceImpl implements BiddingService {

    // TODO Bidding repository

    @Override
    public void placeBid(long productId, double price) {
        System.out.printf("id %d, price: %.0f", productId, price);
    }

}
