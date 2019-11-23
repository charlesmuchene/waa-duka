package io.springgeeks.duka.domain;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(length = 30, nullable = false)
    private String name;
    @Column(length = 8, nullable = false, name = "prod_no")
    private String number;
    @Column(length = 20, name = "serial_number", unique = true, nullable = false)
    private String serialNumber;
    @Column(length = 200)
    private String productDescription;
    private String productUrlImage;
    @ManyToOne @JoinColumn(name = "category_id")
    private Category category;
    @Column(columnDefinition = "varchar(7) not null")
    @Enumerated(EnumType.STRING)
    private Activity activity;
    @Column(name = "on_bid")
    private boolean onBid;
    @Column(name = "rent_per_hour")
    private double rentPerHour;
    private double price;


    public String getProductUrlImage() {
        return productUrlImage;
    }

    public void setProductUrlImage(String productUrlImage) {
        this.productUrlImage = productUrlImage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setDescription(String description) {
        this.productDescription = productDescription;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public boolean isOnBid() {
        return onBid;
    }

    public void setOnBid(boolean onBid) {
        this.onBid = onBid;
    }

    public double getRentPerHour() {
        return rentPerHour;
    }

    public void setRentPerHour(double rentPerHour) {
        this.rentPerHour = rentPerHour;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", description='" + productDescription + '\'' +
                ", productUrlImage='" + productUrlImage + '\'' +
                ", category=" + category +
                ", activity=" + activity +
                ", onBid=" + onBid +
                ", rentPerHour=" + rentPerHour +
                ", price=" + price +
                '}';
    }
}
