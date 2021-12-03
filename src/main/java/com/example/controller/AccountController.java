package com.example.controller;

import com.example.security.JwtProvider;
import com.example.entity.Account;
import com.example.model.account.NewAccountDto;
import com.example.model.account.AccountDto;
import com.example.model.auth.AuthDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.service.AccountService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;
    private final JwtProvider jwtProvider;

    @Autowired
    public AccountController(AccountService accountService, JwtProvider jwtProvider) {
        this.accountService = accountService;
        this.jwtProvider = jwtProvider;
    }

    @GetMapping("/{id}")
    public Account getById(@PathVariable Long id) {
        return accountService.getById(id);
    }

    @GetMapping()
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @PostMapping
    public Account add(@RequestBody NewAccountDto newAccount) {
        return accountService.add(newAccount);
    }

    @PutMapping
    public Account update(@RequestBody AccountDto account) {
        return accountService.update(account);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        return accountService.delete(id);
    }

    @PostMapping("/register/default")
    public AccountDto registerDefaultUser(@RequestBody AuthDto auth) {
        return accountService.registerDefaultUser(auth);
    }

    @PostMapping("/register/business")
    public AccountDto registerBusinessUser(@RequestBody AuthDto auth) {
        return accountService.registerBusinessUser(auth);
    }

    @GetMapping("/business")
    public String getBusinessHi() {
        return "Hi business account";
    }

    @GetMapping("/default")
    public String getDefaultHi() {
        return "Hi default account";
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthDto auth) {
        Account account = accountService.findByLoginAndPassword(auth.getLogin(), auth.getPassword());
        if(account==null) {
            return null;
        }
        String token = jwtProvider.generateToken(account.getLogin(), account.getRole());
        Map<Object, Object> response = new HashMap<>();
        response.put("login", account.getLogin());
        response.put("token", token);

        return ResponseEntity.ok(response);
    }
}
