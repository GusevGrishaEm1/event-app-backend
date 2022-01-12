package com.example.model.defaultUser;

import com.example.entity.DefaultUser;
import com.example.entity.Role;
import com.example.model.user.NewUserDto;
import java.time.LocalDate;

public class NewDefaultUserDto extends NewUserDto {

    private  final String username;
    private  final LocalDate bDay;
    private final String cityName;

    public NewDefaultUserDto(String login, String password, Role role,String cityName, String username, LocalDate bDay) {
        super(login, password, role);
        this.cityName = cityName;
        this.username = username;
        this.bDay = bDay;
    }

    public String getUsername() {
        return username;
    }

    public LocalDate getBDay() {
        return bDay;
    }

    public String getCityName() {
        return cityName;
    }

    public static DefaultUser toEntity(NewDefaultUserDto newDefaultUserDto){
        DefaultUser defaultUserEntity = new DefaultUser();
        defaultUserEntity.setLogin(newDefaultUserDto.getLogin());
        defaultUserEntity.setRole(newDefaultUserDto.getRole());
        defaultUserEntity.setPassword(newDefaultUserDto.getPassword());
        defaultUserEntity.setCityName(newDefaultUserDto.getCityName());
        defaultUserEntity.setUsername(newDefaultUserDto.getUsername());
        defaultUserEntity.setBDay(newDefaultUserDto.getBDay());
        return defaultUserEntity;
    }

    @Override
    public String toString() {
        return "NewDefaultUserDto{" +
                "login='" + getLogin() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", role=" + getRole() + '\'' +
                ", cityName='" + cityName + '\'' +
                ", username='" + username + '\'' +
                ", bDay=" + bDay +
                '}';
    }
}
