package io.springgeeks.duka.domain;

import java.time.LocalDate;

public class ProductOwner {
    private int id;
    private LocalDate ownedDate;
    private LocalDate releasedDate;
    private Product product;
    private SystemUser systemUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getOwnedDate() {
        return ownedDate;
    }

    public void setOwnedDate(LocalDate ownedDate) {
        this.ownedDate = ownedDate;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
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
