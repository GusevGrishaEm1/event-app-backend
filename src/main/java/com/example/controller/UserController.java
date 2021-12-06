package com.example.controller;

import com.example.exception.LoginUserException;
import com.example.security.JwtProvider;
import com.example.entity.User;
import com.example.model.account.NewUserDto;
import com.example.model.account.UserDto;
import com.example.model.auth.AuthDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.service.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final JwtProvider jwtProvider;

    @Autowired
    public UserController(UserService userService, JwtProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping()
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @PostMapping
    public User add(@RequestBody NewUserDto newAccount) {
        return userService.add(newAccount);
    }

    @PatchMapping
    public User update(@RequestBody UserDto account) {
        return userService.update(account);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        return userService.delete(id);
    }

    @PostMapping("/register/default")
    public UserDto registerDefaultUser(@RequestBody AuthDto auth) {
        return userService.registerDefaultUser(auth);
    }

    @PostMapping("/register/business")
    public UserDto registerBusinessUser(@RequestBody AuthDto auth) {
        return userService.registerBusinessUser(auth);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthDto auth) {
        User user = userService.findByLoginAndPassword(auth.getLogin(), auth.getPassword());
        if(user ==null) {
            throw new LoginUserException("Login exception");
        }
        String token = jwtProvider.generateToken(user.getLogin(), user.getRole());
        Map<Object, Object> response = new HashMap<>();
        response.put("login", user.getLogin());
        response.put("token", token);
        return ResponseEntity.ok(response);
    }
}
