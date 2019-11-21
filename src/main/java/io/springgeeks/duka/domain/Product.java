package io.springgeeks.duka.domain;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(length = 30, nullable = false)
    private String productName;
//    @Column(length = 8, nullable = false, name = "prod_no")
//    private String number;
    @Column(length = 20, name = "serial_number", unique = true, nullable = false)
    private String serialNumber;
//    @ManyToOne @JoinColumn(name = "category_id")
//    private Category category;
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;
    @Enumerated(EnumType.STRING)
    @Column(name = "activity")
    private Activity activity;

//    @Column(columnDefinition = "tinyint(1) default 0")
//    private boolean onBid;
//    @Column(name = "rent_per_hour")
//    private double rentPerHour;

    private double price;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

//    public String getNumber() {
//        return number;
//    }
//
//    public void setNumber(String number) {
//        this.number = number;
//    }

//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }


    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

//    public boolean isOnBid() {
//        return onBid;
//    }
//
//    public void setOnBid(boolean onBid) {
//        this.onBid = onBid;
//    }
//
//    public double getRentPerHour() {
//        return rentPerHour;
//    }
//
//    public void setRentPerHour(double rentPerHour) {
//        this.rentPerHour = rentPerHour;
//    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
