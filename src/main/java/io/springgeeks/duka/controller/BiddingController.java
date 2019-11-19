package io.springgeeks.duka.controller;

import io.springgeeks.duka.domain.BidPayload;
import io.springgeeks.duka.domain.Product;
import io.springgeeks.duka.service.BiddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;

@Controller
public class BiddingController {

    private BiddingService biddingService;

    @Autowired
    public BiddingController(BiddingService biddingService) {
        this.biddingService = biddingService;
    }

    @MessageMapping("/place")
    @SendTo("/topic/place")
    public Product productBid(@Valid BidPayload payload) {
        System.out.println(payload);
        return new Product(); // TODO Get product by id
    }
}