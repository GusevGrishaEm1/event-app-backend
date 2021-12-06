package com.example.model.defaultUser;

import com.example.entity.DefaultUser;
import java.time.LocalDate;

public class NewDefaultUserDto {

    private  String username;

    private  String cityName;

    private  LocalDate bDay;

    public String getUsername() {
        return username;
    }

    public String getCityName() {
        return cityName;
    }

    public LocalDate getBDay() {
        return bDay;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setbDay(LocalDate bDay) {
        this.bDay = bDay;
    }

    public static DefaultUser toEntity(NewDefaultUserDto newDefaultUserDto){
        DefaultUser defaultUserEntity = new DefaultUser();
        defaultUserEntity.setUsername(newDefaultUserDto.getUsername());
        defaultUserEntity.setBDay(newDefaultUserDto.getBDay());
        defaultUserEntity.setCityName(newDefaultUserDto.getCityName());
        return defaultUserEntity;
    }

}
