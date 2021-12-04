package com.example.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "defaultUser")
public class DefaultUser {
    @Id
    @Column
    private Long id;

    @Column
    private String userName;

    @Column
    private String cityName;

    @Column
    private LocalDate bDay;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "defaultUser")
    private Account account;

    public DefaultUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public LocalDate getbDay() {
        return bDay;
    }

    public void setbDay(LocalDate bDay) {
        this.bDay = bDay;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
