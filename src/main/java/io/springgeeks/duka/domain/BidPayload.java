package io.springgeeks.duka.domain;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;

public class BidPayload {

    @NotNull(message = "{NotNull.payload.productid}")
    private long productId;

    @NotNull(message = "{NotNull.payload.price}")
    private double price;

//    @Null
//    private LocalDateTime bidDate;

//    @PostConstruct
//    private void populate() {
//        bidDate = LocalDateTime.now();
//    }

    @Override
    public String toString() {
        return "BidPayload{" +
                "productId=" + productId +
                ", price=" + price +
//                ", bidDate=" + bidDate +
                '}';
    }
}
