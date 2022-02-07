package com.example.controller;

import com.example.model.auth.AuthDto;
import com.example.model.businessUser.BusinessUserDto;
import com.example.model.businessUser.NewBusinessUserDto;
import com.example.model.defaultUser.DefaultUserDto;
import com.example.model.defaultUser.NewDefaultUserDto;
import com.example.model.user.UserDto;
import com.example.security.JwtProvider;
import com.example.service.BusinessUserService;
import com.example.service.DefaultUserService;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
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

    @PostMapping("/defaults")
    public @ResponseBody
    DefaultUserDto registerDefaultUser(@RequestBody NewDefaultUserDto newDefaultUser) {
        LOGGER.trace("Enter method: registerDefaultUser(). Params: {}", newDefaultUser);
        return defaultUserService.save(newDefaultUser);
    }

    @PostMapping("/businesses")
    public @ResponseBody
    BusinessUserDto registerBusinessUser(@RequestBody NewBusinessUserDto newBusinessUser) {
        LOGGER.trace("Enter method: registerBusinessUser(). Params: {}", newBusinessUser);
        return businessUserService.save(newBusinessUser);
    }

    @PostMapping
    public @ResponseBody
    Object login(@RequestBody AuthDto auth) {
        LOGGER.trace("Enter method: login(). Params: {}", auth);
        UserDto user = userService.findByLoginAndPassword(auth.getLogin(), auth.getPassword());
        String token = jwtProvider.generateToken(user.getId(), user.getLogin(), user.getRole());
        if (user.getRole().name().equals("USER_DEFAULT")) {
            DefaultUserDto res = DefaultUserDto.toDto(defaultUserService.getById(user.getId()));
            res.setToken(token);
            return res;
        }
        else {
            BusinessUserDto res = BusinessUserDto.toDto(businessUserService.getById(user.getId()));
            res.setToken(token);
            return res;
        }
    }

    @PutMapping("/defaults")
    public DefaultUserDto updateDefaultProfile(@RequestBody DefaultUserDto defaultUserDto) {
        LOGGER.trace("Enter method: updateDefaultProfile(). Params: {}", defaultUserDto);
        return defaultUserService.update(defaultUserDto);
    }

    @PutMapping("/businesses")
    public BusinessUserDto updateBusinessProfile(@RequestBody BusinessUserDto businessUserDto) {
        LOGGER.trace("Enter method: updateBusinessProfile(). Params: {}", businessUserDto);
        return businessUserService.update(businessUserDto);
    }

}
