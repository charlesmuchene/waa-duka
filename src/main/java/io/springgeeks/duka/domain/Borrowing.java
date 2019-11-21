package io.springgeeks.duka.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "borrowing")
public class Borrowing {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "borrowed_date")
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm")
    @NotNull
    private LocalDateTime borrowedDate;
    @Column(name = "return_date")
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm")
    @NotNull
    private LocalDateTime returnDate;
    @Column(length = 500)
    private String description;
    @ManyToOne @JoinColumn(name = "user_id", nullable = false)
    private SystemUser systemUser;
    @ManyToOne @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    @Column(name = "amount_paid")
    private double amountPaid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDateTime borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SystemUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }
}
