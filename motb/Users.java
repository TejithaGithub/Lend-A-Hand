package com.lendhand.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @NotEmpty
    @NotBlank
    String name;
    @Column(unique = true)
    @NotNull
    String emailId;
    @Column(nullable = false)
    String password;
    String phone;
    String address;
    @NotNull
    String role; // admin / ngo / donor

    String certificate; // image/pdf

    int status; // NGO status -> 0 : pending , 1 : accepted, 2 : rejected
    String ngoDescription;

    public Users() {
    }

    public Users(Long id, String name, String emailId, String password, String phone, String address, String role,
            String certificate, int status, String ngoDescription) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.role = role;
        this.certificate = certificate;
        this.status = status;
        this.ngoDescription = ngoDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNgoDescription() {
        return ngoDescription;
    }

    public void setNgoDescription(String ngoDescription) {
        this.ngoDescription = ngoDescription;
    }

    @Override
    public String toString() {
        return "Users [address=" + address + ", certificate=" + certificate + ", emailId=" + emailId + ", id=" + id
                + ", name=" + name + ", ngoDescription=" + ngoDescription + ", password=" + password + ", phone="
                + phone + ", role=" + role + ", status=" + status + "]";
    }

}
