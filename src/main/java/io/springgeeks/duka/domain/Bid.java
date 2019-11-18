package io.springgeeks.duka.domain;

import java.time.LocalDate;

public class Bid {
    private int id;
    private double amount;
    private LocalDate biddingDate;
    private Product product;
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
