package com.lendhand.model;

public class DonorInfo {
    private String donorName;
    private String donorPhone;
    private String productName;
    private int quantity;
    private String description;

    public DonorInfo()
    {

    }
    public DonorInfo(String donorName,String donorPhone,String productName,int quantity,String description)
    {
        this.donorName = donorName;
        this.donorPhone = donorPhone;
        this.productName = productName;
        this.quantity = quantity;
        this.description = description;
    }
    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getDonorName() {
        return donorName;
    }
    public void setDonorPhone(String donorPhone) {
        this.donorPhone = donorPhone;
    }

    public String getDonorPhone() {
        return donorPhone;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
