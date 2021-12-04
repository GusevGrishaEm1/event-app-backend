package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name="businessUser")
public class BusinessUser {
    @Id
    @Column
    private Long id;

    @Column
    private String companyName;

    @Column
    private String address;

    // @OneToOne(cascade = CascadeType.ALL, mappedBy = "businessUser")
    // private Account account;


    public BusinessUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
