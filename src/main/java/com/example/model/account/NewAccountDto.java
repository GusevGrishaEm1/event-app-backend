package com.example.model.account;

import com.example.entity.Account;
import com.example.entity.Role;

public class NewAccountDto {

    private String login;

    private String password;

    private Role role;

    public NewAccountDto(String login, String password, Role role) {
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

    public static Account toEntity(NewAccountDto accountDto) {
        Account accountEntity = new Account();
        accountEntity.setLogin(accountDto.getLogin());
        accountEntity.setPassword(accountDto.getPassword());
        accountEntity.setRole(accountDto.getRole());
        return accountEntity;
    }
}
