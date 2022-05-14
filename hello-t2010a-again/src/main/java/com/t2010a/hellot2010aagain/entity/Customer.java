package com.t2010a.hellot2010aagain.entity;

import java.time.LocalDateTime;

public class Customer {

    private String customerID;
    private String fullName;
    private String email;
    private String phone;
    private LocalDateTime dob;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int status; // xoá mềm

    public Customer(String customerID, String fullName, String email, String phone, LocalDateTime dob, LocalDateTime createdAt, LocalDateTime updatedAt, int status) {
        this.rollNumber = customerID;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public Customer(String customerID, String fullName, String email, String phone, LocalDateTime dob) {
        this.customerID = customerID;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = 1;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dob=" + dob +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", status=" + status +
                '}';
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
