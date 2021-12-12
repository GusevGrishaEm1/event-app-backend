package com.example.model.defaultUser;

import com.example.entity.DefaultUser;
import com.example.entity.Role;
import com.example.model.user.NewUserDto;

import java.time.LocalDate;

public class NewDefaultUserDto extends NewUserDto {

    private  final String username;
    private  final String cityName;
    private  final LocalDate bDay;

    public NewDefaultUserDto(String login, String password, Role role, String username, String cityName, LocalDate bDay) {
        super(login, password, role);
        this.username = username;
        this.cityName = cityName;
        this.bDay = bDay;
    }

    public String getUsername() {
        return username;
    }

    public String getCityName() {
        return cityName;
    }

    public LocalDate getBDay() {
        return bDay;
    }

    public static DefaultUser toEntity(NewDefaultUserDto newDefaultUserDto){
        DefaultUser defaultUserEntity = new DefaultUser();
        defaultUserEntity.setLogin(newDefaultUserDto.getLogin());
        defaultUserEntity.setRole(newDefaultUserDto.getRole());
        defaultUserEntity.setPassword(newDefaultUserDto.getPassword());
        defaultUserEntity.setUsername(newDefaultUserDto.getUsername());
        defaultUserEntity.setBDay(newDefaultUserDto.getBDay());
        defaultUserEntity.setCityName(newDefaultUserDto.getCityName());
        return defaultUserEntity;
    }

}
