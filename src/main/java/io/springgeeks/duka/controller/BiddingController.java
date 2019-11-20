package io.springgeeks.duka.controller;

import io.springgeeks.duka.domain.Bid;
import io.springgeeks.duka.domain.Product;
import io.springgeeks.duka.service.BiddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class BiddingController {

    private BiddingService biddingService;

    @Autowired
    public BiddingController(BiddingService biddingService) {
        this.biddingService = biddingService;
    }

    @MessageMapping("/place")
    @SendTo("/topic/place")
    public Product productBid(Bid bid) {
        return biddingService.placeBid(bid);
    }
}
