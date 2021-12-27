package com.example.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class DefaultUser extends User {

    @Column(name = "username")
    private String username;

    @Column(name = "cityName")
    private String cityName;

    @Column(name = "bDay")
    private LocalDate bDay;

    public DefaultUser() {
    }

    public DefaultUser(Long id, String login, String password, Role role, String username, String cityName, LocalDate bDay) {
        super(id, login, password, role);
        this.username = username;
        this.cityName = cityName;
        this.bDay = bDay;
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

    @Override
    public String toString() {
        return "DefaultUser{" +
                "username='" + username + '\'' +
                ", cityName='" + cityName + '\'' +
                ", bDay=" + bDay +
                '}';
    }
}
