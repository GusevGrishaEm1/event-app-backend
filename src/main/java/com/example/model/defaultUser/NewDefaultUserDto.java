package com.example.model.defaultUser;

import com.example.entity.DefaultUser;

import java.time.LocalDate;

public class NewDefaultUserDto {
    private String userName;

    private String cityName;

    private LocalDate bDay;

    public NewDefaultUserDto(String userName, String cityName, LocalDate bDay) {
        this.userName = userName;
        this.cityName = cityName;
        this.bDay = bDay;
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

    public static DefaultUser toEntity(NewDefaultUserDto newDefaultUserDto){
        DefaultUser defaultUserEntity = new DefaultUser();
        defaultUserEntity.setUserName(newDefaultUserDto.getUserName());
        defaultUserEntity.setbDay(newDefaultUserDto.getbDay());
        defaultUserEntity.setCityName(newDefaultUserDto.getCityName());
        return defaultUserEntity;
    }
}
