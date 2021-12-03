package com.example.model.account;

import com.example.entity.Account;
import com.example.entity.Role;

public class AccountDto {

    private Long id;

    private String login;

    private String password;

    private Role role;

    public AccountDto() {}

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public static Account toEntity(AccountDto accountDto) {
        Account accountEntity = new Account();
        accountEntity.setId(accountDto.getId());
        accountEntity.setLogin(accountDto.getLogin());
        accountEntity.setPassword(accountDto.getPassword());
        accountEntity.setRole(accountDto.getRole());
        return accountEntity;
    }

    public static AccountDto toDto(Account accountEntity) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(accountEntity.getId());
        accountDto.setLogin(accountEntity.getLogin());
        accountDto.setPassword(accountEntity.getPassword());
        accountDto.setRole(accountEntity.getRole());
        return accountDto;
    }
}
