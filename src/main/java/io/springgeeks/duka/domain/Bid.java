package io.springgeeks.duka.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Bid
 * <p>
 * Use by messaging
 */
@Entity
@Table(name = "bids")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "product_id")
    @NotNull(message = "{NotNull.payload.productid}")
    private long productId;

    @NotNull(message = "{NotNull.payload.price}")
    private double price;

    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "bid_date")
    @DateTimeFormat(pattern = "MM/dd/yyyy hh:mm")
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

    public void setBidDate(LocalDateTime bidDate) {
        this.bidDate = bidDate;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "productId=" + productId +
                ", price=" + price +
                ", bidDate=" + bidDate +
                ", userId=" + userId +
                '}';
    }
}
