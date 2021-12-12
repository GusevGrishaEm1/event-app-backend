package com.example.controller;

import com.example.entity.BusinessUser;
import com.example.model.businessUser.BusinessUserDto;
import com.example.model.businessUser.NewBusinessUserDto;
import com.example.service.BusinessUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/business")
public class BusinessUserController {

    private final BusinessUserService businessUserService;

    @Autowired
    public BusinessUserController(BusinessUserService businessUserService) {
        this.businessUserService = businessUserService;
    }

    @GetMapping("/{id}")
    public BusinessUser getById(@PathVariable Long id){
        return businessUserService.getById(id);
    }

    @GetMapping
    public List<BusinessUser> getAll(){
        return businessUserService.getAll();
    }

    @GetMapping("/hi")
    public String getHI() {
        return "HI business user";
    }

    @PostMapping
    public BusinessUser add(@RequestBody NewBusinessUserDto newBusinessUserDto){
        return businessUserService.add(newBusinessUserDto);
    }

    @PutMapping
    public BusinessUser update(@RequestBody BusinessUserDto businessUserDto){
        return businessUserService.update(businessUserDto);
    }

    @DeleteMapping("/{id}")
    public long delete(@PathVariable Long id){
        businessUserService.delete(id);
        return id;
    }
}
