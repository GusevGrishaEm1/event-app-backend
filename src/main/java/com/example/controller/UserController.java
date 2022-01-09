package com.example.controller;

import com.example.model.auth.AuthDto;
import com.example.model.businessUser.BusinessUserDto;
import com.example.model.businessUser.NewBusinessUserDto;
import com.example.model.defaultUser.DefaultUserDto;
import com.example.model.defaultUser.NewDefaultUserDto;
import com.example.security.JwtProvider;
import com.example.model.user.UserDto;
import com.example.service.BusinessUserService;
import com.example.service.DefaultUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins="http://localhost:3000")
public class UserController {

    private final UserService userService;
    private final BusinessUserService businessUserService;
    private final DefaultUserService defaultUserService;
    private final JwtProvider jwtProvider;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService, BusinessUserService businessUserService, DefaultUserService defaultUserService, JwtProvider jwtProvider) {
        this.userService = userService;
        this.businessUserService = businessUserService;
        this.defaultUserService = defaultUserService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/register/default")
    public @ResponseBody DefaultUserDto registerDefaultUser(@RequestBody NewDefaultUserDto newDefaultUser) {
        LOGGER.trace("Enter method: registerDefaultUser(). Params: {}", newDefaultUser);
        return defaultUserService.registerDefaultUser(newDefaultUser);
    }

    @PostMapping("/register/business")
    public @ResponseBody BusinessUserDto registerBusinessUser(@RequestBody NewBusinessUserDto newBusinessUser) {
        LOGGER.trace("Enter method: registerBusinessUser(). Params: {}", newBusinessUser);
        return businessUserService.registerBusinessUser(newBusinessUser);
    }

    @PostMapping("/login")
    public @ResponseBody String login(@RequestBody AuthDto auth) {
        LOGGER.trace("Enter method: login(). Params: {}", auth);
        UserDto user = userService.findByLoginAndPassword(auth.getLogin(), auth.getPassword());
        return jwtProvider.generateToken(user.getId(), user.getLogin(), user.getRole());
    }

    @GetMapping("/profile/default")
    public @ResponseBody DefaultUserDto getDefaultProfile(@RequestHeader("Authorization") String token) {
        LOGGER.trace("Enter method: getDefaultProfile(). Params: {}", token);
        String stillToken = jwtProvider.resolveToken(token);
        return  DefaultUserDto.toDto(defaultUserService.getById(jwtProvider.getIdFromToken(stillToken)));
    }

    @GetMapping("/profile/business")
    public @ResponseBody BusinessUserDto getBusinessProfile(@RequestHeader("Authorization") String token) {
        LOGGER.trace("Enter method: getBusinessProfile(). Params: {}", token);
        String stillToken = jwtProvider.resolveToken(token);
        return BusinessUserDto.toDto(businessUserService.getById(jwtProvider.getIdFromToken(stillToken)));
    }
}
