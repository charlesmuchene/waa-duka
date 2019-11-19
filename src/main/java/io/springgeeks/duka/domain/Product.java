package io.springgeeks.duka.domain;

public class Product {

    private long id;

    private String name;

    private String number;

    private String serialNumber;

    private Category category;

    private Activity activity;

    private boolean onBid;

    private double rentPerHour;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
                ", category=" + category +
                ", activity=" + activity +
                ", onBid=" + onBid +
                ", rentPerHour=" + rentPerHour +
                ", price=" + price +
                '}';
    }
}
