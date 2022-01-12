package com.example.model.defaultUser;

import com.example.entity.DefaultUser;
import com.example.model.user.UserDto;
import java.time.LocalDate;

public class DefaultUserDto extends UserDto {

    private String username;
    private LocalDate bDay;
    private String cityName;

    public DefaultUserDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getBDay() {
        return bDay;
    }

    public void setBDay(LocalDate bDay) {
        this.bDay = bDay;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public static DefaultUser toEntity(DefaultUserDto defaultUserDto){
        DefaultUser defaultUserEntity = new DefaultUser();
        defaultUserEntity.setId(defaultUserDto.getId());
        defaultUserEntity.setLogin(defaultUserDto.getLogin());
        defaultUserEntity.setPassword(defaultUserDto.getPassword());
        defaultUserEntity.setRole(defaultUserDto.getRole());
        defaultUserEntity.setCityName(defaultUserDto.getCityName());
        defaultUserEntity.setUsername(defaultUserDto.getUsername());
        defaultUserEntity.setBDay(defaultUserDto.getBDay());
        return defaultUserEntity;
    }

    public static DefaultUserDto toDto(DefaultUser defaultUserEntity){
        DefaultUserDto defaultUserDto = new DefaultUserDto();
        defaultUserDto.setId(defaultUserEntity.getId());
        defaultUserDto.setLogin(defaultUserEntity.getLogin());
        defaultUserDto.setPassword(defaultUserEntity.getPassword());
        defaultUserDto.setRole(defaultUserEntity.getRole());
        defaultUserDto.setCityName(defaultUserEntity.getCityName());
        defaultUserDto.setUsername(defaultUserEntity.getUsername());
        defaultUserDto.setBDay(defaultUserEntity.getBDay());
        return defaultUserDto;
    }

    @Override
    public String toString() {
        return "DefaultUserDto{" +
                "id=" + getId() + '\'' +
                ", login='" + getLogin() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", role=" + getRole() + '\'' +
                ", cityName='" + cityName + '\'' +
                ", username='" + username + '\'' +
                ", bDay=" + bDay +
                '}';
    }
}
