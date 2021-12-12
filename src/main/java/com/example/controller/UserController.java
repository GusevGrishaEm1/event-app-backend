package com.example.controller;

import com.example.exception.LoginUserException;
import com.example.model.auth.AuthDto;
import com.example.model.businessUser.BusinessUserDto;
import com.example.model.businessUser.NewBusinessUserDto;
import com.example.model.defaultUser.DefaultUserDto;
import com.example.model.defaultUser.NewDefaultUserDto;
import com.example.security.JwtProvider;
import com.example.entity.User;
import com.example.model.user.UserDto;
import com.example.service.BusinessUserService;
import com.example.service.DefaultUserService;
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
    private final BusinessUserService businessUserService;
    private final DefaultUserService defaultUserService;
    private final JwtProvider jwtProvider;

    @Autowired
    public UserController(UserService userService, BusinessUserService businessUserService, DefaultUserService defaultUserService, JwtProvider jwtProvider) {
        this.userService = userService;
        this.businessUserService = businessUserService;
        this.defaultUserService = defaultUserService;
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

    @PatchMapping
    public User update(@RequestBody UserDto account) {
        return userService.update(account);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        return userService.delete(id);
    }

    @PostMapping("/register/default")
    public DefaultUserDto registerDefaultUser(@RequestBody NewDefaultUserDto newDefaultUser) {
        return defaultUserService.registerDefaultUser(newDefaultUser);
    }

    @PostMapping("/register/business")
    public BusinessUserDto registerBusinessUser(@RequestBody NewBusinessUserDto newBusinessUserDto) {
        return businessUserService.registerBusinessUser(newBusinessUserDto);
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
        response.put("role", user.getRole());
        response.put("token", token);
        return ResponseEntity.ok(response);
    }
}
