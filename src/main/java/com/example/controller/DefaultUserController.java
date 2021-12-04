package com.example.controller;

import com.example.service.DefaultUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/defaultUser")
public class DefaultUserController {

    private final DefaultUserService defaultUserService;

    @Autowired
    public DefaultUserController(DefaultUserService defaultUserService) {
        this.defaultUserService = defaultUserService;
    }


}
