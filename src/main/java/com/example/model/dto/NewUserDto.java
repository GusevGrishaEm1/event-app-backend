package com.example.model.dto;

public class NewUserDto {

    private String login;

    private String password;

    private String cityName;

    public NewUserDto() {
    }

    public NewUserDto(String login, String password, String cityName) {
        this.login = login;
        this.password = password;
        this.cityName = cityName;
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
