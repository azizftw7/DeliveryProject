package model;

public class Product {
    private int id;
    private String name;
    private String status;
    private String qrCode; 
    private double price;

    
    public Product() {}


public Product(int id, String name, String status, String qrCode, double price) {
    this.id = id;
    this.name = name;
    this.status = status;
    this.qrCode = qrCode;
    this.price = price;
}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getQrCode() {
        return qrCode;
    }
    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", status=" + status + ", qrCode=" + qrCode + "]";
    }
}
