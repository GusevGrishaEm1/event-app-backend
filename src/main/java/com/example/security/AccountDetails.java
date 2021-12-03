package com.example.security;

import com.example.entity.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class AccountDetails implements UserDetails {

    private String login;
    private String password;
    private List<GrantedAuthority> authorities;

    public static AccountDetails fromAccountEntityToAccountDetails(Account account) {
        AccountDetails accountDetails = new AccountDetails();
        accountDetails.login = account.getLogin();
        accountDetails.password = account.getPassword();
        accountDetails.authorities = AuthorityUtils.createAuthorityList(account.getRole().name());
        return accountDetails;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
