package io.springgeeks.duka.domain;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Bid payload
 * <p>
 * Use by messaging
 */
public class BidPayload {

    @NotNull(message = "{NotNull.payload.productid}")
    private long productId;

    @NotNull(message = "{NotNull.payload.price}")
    private double price;

    private LocalDateTime bidDate = LocalDateTime.now();

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getBidDate() {
        return bidDate;
    }

    @Override
    public String toString() {
        return "BidPayload{" +
                "productId=" + productId +
                ", price=" + price +
                ", bidDate=" + bidDate +
                '}';
    }
}
