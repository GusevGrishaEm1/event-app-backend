package com.example.entity;

import javax.persistence.*;

@Entity
public class BusinessUser extends User {

    @Column(name = "companyName")
    private String companyName;

    @Column(name = "address")
    private String address;

    public BusinessUser() {}

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "BusinessUser{" +
                super.toString() +
                "companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
