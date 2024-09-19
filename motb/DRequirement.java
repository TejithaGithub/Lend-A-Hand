package com.lendhand.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DRequirement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reqId;
    private Long ngoId;
    private Long driveId;
    private String reqName;
    private int quantity;

    public DRequirement() {
    }

    public DRequirement(Long reqId, Long ngoId, Long driveId, String reqName, int quantity) {
        this.reqId = reqId;
        this.ngoId = ngoId;
        this.driveId = driveId;
        this.reqName = reqName;
        this.quantity = quantity;
    }

    public Long getReqId() {
        return reqId;
    }

    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    public Long getNgoId() {
        return ngoId;
    }

    public void setNgoId(Long ngoId) {
        this.ngoId = ngoId;
    }

    public Long getDriveId() {
        return driveId;
    }

    public void setDriveId(Long driveId) {
        this.driveId = driveId;
    }

    public String getReqName() {
        return reqName;
    }

    public void setReqName(String reqName) {
        this.reqName = reqName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "DRequirment [driveId=" + driveId + ", ngoId=" + ngoId + ", quantity=" + quantity + ", reqId=" + reqId
                + ", reqName=" + reqName + "]";
    }

}
