package com.example.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "defaultUser")
public class DefaultUser {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "cityName")
    private String cityName;

    @Column(name = "bDay")
    private LocalDate bDay;

    @OneToOne
    @JoinColumn(name = "usr_id", referencedColumnName = "id")
    private User user;

    public DefaultUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public LocalDate getBDay() {
        return bDay;
    }

    public void setBDay(LocalDate bDay) {
        this.bDay = bDay;
    }

}
