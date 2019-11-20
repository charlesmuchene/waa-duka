package io.springgeeks.duka.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bid")
public class Bid {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double amount;
    @Column(name = "bidding_date")
    private LocalDate biddingDate;
    @ManyToOne @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    @ManyToOne @JoinColumn(name = "user_id", nullable = false)
    private SystemUser systemUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getBiddingDate() {
        return biddingDate;
    }

    public void setBiddingDate(LocalDate biddingDate) {
        this.biddingDate = biddingDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public SystemUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }
}
