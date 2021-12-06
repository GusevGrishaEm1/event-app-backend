package com.example.model.defaultUser;

import com.example.entity.DefaultUser;

import java.time.LocalDate;

public class DefaultUserDto {
    private Long id;
    private String userName;
    private String cityName;
    private LocalDate bDay;

    public DefaultUserDto() {
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

    public LocalDate getBDay() {
        return bDay;
    }

    public void setBDay(LocalDate bDay) {
        this.bDay = bDay;
    }

    public static DefaultUser toEntity(DefaultUserDto defaultUserDto){
        DefaultUser userEntity=new DefaultUser();
        userEntity.setUsername(defaultUserDto.getUserName());
        userEntity.setId(defaultUserDto.getId());
        userEntity.setCityName(defaultUserDto.getCityName());
        userEntity.setBDay(defaultUserDto.getBDay());
        return userEntity;
    }

    public static DefaultUserDto toDto(DefaultUser defaultUser){
        DefaultUserDto userDto=new DefaultUserDto();
        userDto.setUserName(defaultUser.getUsername());
        userDto.setId(defaultUser.getId());
        userDto.setCityName(defaultUser.getCityName());
        userDto.setBDay(defaultUser.getBDay());
        return userDto;
    }
}
