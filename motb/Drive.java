package com.lendhand.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Drive {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long driveId;

    private Long ngoId;
    private String driveName;
    private Timestamp createDate;

    private String place;
    private String description;

    private int donorCount;

    public Drive() {
    }

    public Drive(Long driveId, Long ngoId, String driveName, Timestamp createDate, String place, String description,
            int donorCount) {
        this.driveId = driveId;
        this.ngoId = ngoId;
        this.driveName = driveName;
        this.createDate = createDate;
        this.place = place;
        this.description = description;
        this.donorCount = donorCount;
    }

    public Long getDriveId() {
        return driveId;
    }

    public void setDriveId(Long driveId) {
        this.driveId = driveId;
    }

    public Long getNgoId() {
        return ngoId;
    }

    public void setNgoId(Long ngoId) {
        this.ngoId = ngoId;
    }

    public String getDriveName() {
        return driveName;
    }

    public void setDriveName(String driveName) {
        this.driveName = driveName;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDonorCount() {
        return donorCount;
    }

    public void setDonorCount(int donorCount) {
        this.donorCount = donorCount;
    }

    @Override
    public String toString() {
        return "Drive [createDate=" + createDate + ", description=" + description + ", donorCount=" + donorCount
                + ", driveId=" + driveId + ", driveName=" + driveName + ", ngoId=" + ngoId + ", place=" + place + "]";
    }

}
