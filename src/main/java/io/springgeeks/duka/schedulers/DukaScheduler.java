package io.springgeeks.duka.schedulers;

import io.springgeeks.duka.domain.Product;
import io.springgeeks.duka.service.BiddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DukaScheduler {

    private SimpMessagingTemplate simpMessagingTemplate;
    private BiddingService biddingService;

    @Autowired
    public DukaScheduler(SimpMessagingTemplate simpMessagingTemplate, BiddingService biddingService) {
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.biddingService = biddingService;
    }

    @PostConstruct
//    @Scheduled(fixedDelay = 1000) TODO Activate
    private void broadcastDukaState() {
        simpMessagingTemplate.convertAndSend("/topic/place", new Product());
    }
}
