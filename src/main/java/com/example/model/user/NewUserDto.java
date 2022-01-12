package com.example.model.user;

import com.example.entity.User;
import com.example.entity.Role;

public class NewUserDto {

    private String login;

    private String password;

    private Role role;

    public NewUserDto(String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public static User toEntity(NewUserDto newUserDto) {
        User userEntity = new User();
        userEntity.setLogin(newUserDto.getLogin());
        userEntity.setPassword(newUserDto.getPassword());
        userEntity.setRole(newUserDto.getRole());
        return userEntity;
    }
}
