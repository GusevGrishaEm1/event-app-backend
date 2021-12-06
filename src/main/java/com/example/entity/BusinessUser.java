package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name="businessUser")
public class BusinessUser {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "companyName")
    private String companyName;

    @Column(name = "address")
    private String address;

    @OneToOne
    @JoinColumn(name = "usr_id", referencedColumnName = "id")
    private User user;

    public BusinessUser() {}

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
