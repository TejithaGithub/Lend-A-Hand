package com.lendhand.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DonationsTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long donationId;
    private Long donorId;
    private String productName;
    private int quantity;
    private String quality;
    private String productCategory;
    private String description;
    private Long ngoId;
    // private String[] images;
    private int driveId;
    private boolean isDonated;
    private boolean pickUpRequire;

    public DonationsTable() {
    }

    public DonationsTable(Long donationId, Long donorId, String productName, int quantity, String quality,
            String productCategory, String description, Long ngoId, boolean isDonated, boolean pickUpRequire,
            int driveId) {
        this.donationId = donationId;
        this.donorId = donorId;
        this.productName = productName;
        this.quantity = quantity;
        this.quality = quality;
        this.productCategory = productCategory;
        this.description = description;
        this.ngoId = ngoId;
        this.isDonated = isDonated;
        this.pickUpRequire = pickUpRequire;
        this.driveId = driveId;
    }

    public Long getDonationId() {
        return donationId;
    }

    public void setDonationId(Long donationId) {
        this.donationId = donationId;
    }

    public Long getDonorId() {
        return donorId;
    }

    public void setDonorId(Long donorId) {
        this.donorId = donorId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getNgoId() {
        return ngoId;
    }

    public void setNgoId(Long ngoId) {
        this.ngoId = ngoId;
    }

    public boolean isDonated() {
        return isDonated;
    }

    public void setDonated(boolean isDonated) {
        this.isDonated = isDonated;
    }

    public boolean isPickUpRequire() {
        return pickUpRequire;
    }

    public void setPickUpRequire(boolean pickUpRequire) {
        this.pickUpRequire = pickUpRequire;
    }

    public int getDriveId() {
        return driveId;
    }

    public void setDriveId(int driveId) {
        this.driveId = driveId;
    }

    @Override
    public String toString() {
        return "DonationsTable [description=" + description + ", donationId=" + donationId + ", donorId=" + donorId
                + ", driveId=" + driveId + ", isDonated=" + isDonated + ", ngoId=" + ngoId + ", pickUpRequire="
                + pickUpRequire + ", productCategory=" + productCategory + ", productName=" + productName + ", quality="
                + quality + ", quantity=" + quantity + "]";
    }

}
