package com.example.model.defaultUser;

import com.example.entity.DefaultUser;
import com.example.entity.Role;
import com.example.model.user.UserDto;
import java.time.LocalDate;

public class DefaultUserDto extends UserDto {
    private String userName;
    private String cityName;
    private LocalDate bDay;

    public DefaultUserDto() {
    }

    public DefaultUserDto(Long id, String login, String password, Role role, String userName, String cityName, LocalDate bDay) {
        super(id, login, password, role);
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

    public LocalDate getBDay() {
        return bDay;
    }

    public void setBDay(LocalDate bDay) {
        this.bDay = bDay;
    }

    public static DefaultUser toEntity(DefaultUserDto defaultUserDto){
        DefaultUser defaultUserEntity = new DefaultUser();
        defaultUserEntity.setId(defaultUserDto.getId());
        defaultUserEntity.setLogin(defaultUserDto.getLogin());
        defaultUserEntity.setPassword(defaultUserDto.getPassword());
        defaultUserEntity.setRole(defaultUserDto.getRole());
        defaultUserEntity.setUsername(defaultUserDto.getUserName());
        defaultUserEntity.setCityName(defaultUserDto.getCityName());
        defaultUserEntity.setBDay(defaultUserDto.getBDay());
        return defaultUserEntity;
    }

    public static DefaultUserDto toDto(DefaultUser defaultUserEntity){
        DefaultUserDto defaultUserDto = new DefaultUserDto();
        defaultUserDto.setId(defaultUserEntity.getId());
        defaultUserDto.setLogin(defaultUserEntity.getLogin());
        defaultUserDto.setPassword(defaultUserEntity.getPassword());
        defaultUserDto.setRole(defaultUserEntity.getRole());
        defaultUserDto.setUserName(defaultUserEntity.getUsername());
        defaultUserDto.setCityName(defaultUserEntity.getCityName());
        defaultUserDto.setBDay(defaultUserEntity.getBDay());
        return defaultUserDto;
    }
}
