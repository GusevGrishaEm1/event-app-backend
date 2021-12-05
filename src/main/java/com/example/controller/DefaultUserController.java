package com.example.controller;

import com.example.entity.DefaultUser;
import com.example.model.defaultUser.DefaultUserDto;
import com.example.model.defaultUser.NewDefaultUserDto;
import com.example.service.DefaultUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/default")
public class DefaultUserController {

    private final DefaultUserService defaultUserService;

    @Autowired
    public DefaultUserController(DefaultUserService defaultUserService) {
        this.defaultUserService = defaultUserService;
    }

    @GetMapping("/{id}")
    public DefaultUser getById(@PathVariable Long id){
        return defaultUserService.getById(id);
    }

    @GetMapping
    public List<DefaultUser> getAll(){return defaultUserService.getAll();}

    @PostMapping
    public DefaultUser add(@RequestBody NewDefaultUserDto newDefaultUser){
        return defaultUserService.add(newDefaultUser);
    }

    @PutMapping
    public DefaultUser update(@RequestBody DefaultUserDto defaultUserDto){
        return defaultUserService.update(defaultUserDto);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id){
        return defaultUserService.delete(id);
    }
}
