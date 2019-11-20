package io.springgeeks.duka.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "product_owner")
public class ProductOwner {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "owned_date")
    private LocalDate ownedDate;
    @Column(name = "released_date")
    private LocalDate releasedDate;
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
