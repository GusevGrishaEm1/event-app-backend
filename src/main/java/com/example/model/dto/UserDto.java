package com.example.model.dto;

public class UserDto {

    private Long id;

    private String login;

    private String password;

    private String cityName;

    public UserDto(Long id, String login, String password, String cityName) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.cityName = cityName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
