package com.example.controller;

import com.example.exception.UserNotFoundException;
import com.example.model.auth.AuthDto;
import com.example.model.businessUser.BusinessUserDto;
import com.example.model.businessUser.NewBusinessUserDto;
import com.example.model.defaultUser.DefaultUserDto;
import com.example.model.defaultUser.NewDefaultUserDto;
import com.example.security.JwtProvider;
import com.example.model.user.UserDto;
import com.example.service.BusinessUserService;
import com.example.service.DefaultUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.service.UserService;
import java.util.HashMap;
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
        UserDto user = userService.findByLoginAndPassword(auth.getLogin(), auth.getPassword());
        if(user == null) {
            throw new UserNotFoundException("User not found!");
        }
        String token = jwtProvider.generateToken(user.getId(), user.getLogin(), user.getRole());
        Map<Object, Object> response = new HashMap<>();
        response.put("login", user.getLogin());
        response.put("role", user.getRole());
        response.put("token", token);
        return ResponseEntity.ok(response);
    }
}
