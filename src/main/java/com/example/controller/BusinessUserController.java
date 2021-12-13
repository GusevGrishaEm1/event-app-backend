package com.example.controller;

import com.example.entity.BusinessUser;
import com.example.entity.Event;
import com.example.entity.User_Event;
import com.example.model.businessUser.BusinessUserDto;
import com.example.model.businessUser.NewBusinessUserDto;
import com.example.model.event.NewEventDto;
import com.example.model.user_event.NewUser_EventDto;
import com.example.service.BusinessUserService;
import com.example.service.EventService;
import com.example.service.User_EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/business")
public class BusinessUserController {

    private final BusinessUserService businessUserService;
    private final EventService eventService;
    private final User_EventService user_eventService;

    @Autowired
    public BusinessUserController(BusinessUserService businessUserService, EventService eventService, User_EventService user_eventService) {
        this.businessUserService = businessUserService;
        this.eventService = eventService;
        this.user_eventService = user_eventService;
    }

    @GetMapping("/{id}")
    public BusinessUser getById(@PathVariable Long id) {
        return businessUserService.getById(id);
    }

    @GetMapping
    public List<BusinessUser> getAll() {
        return businessUserService.getAll();
    }

    @GetMapping("/hi")
    public String getHI() {
        return "HI business user";
    }

    @PostMapping
    public BusinessUser add(@RequestBody NewBusinessUserDto newBusinessUserDto) {
        return businessUserService.add(newBusinessUserDto);
    }

    @PutMapping
    public BusinessUser update(@RequestBody BusinessUserDto businessUserDto) {
        return businessUserService.update(businessUserDto);
    }

    @DeleteMapping("/{id}")
    public long delete(@PathVariable Long id) {
        businessUserService.delete(id);
        return id;
    }

    @PostMapping("/{id}/newEvent")
    public ResponseEntity addEvent(@RequestBody NewEventDto newEventDto, @PathVariable Long id) {
        if (businessUserService.getById(id) != null) {
            Event event=eventService.add(newEventDto);
            User_Event user_event=user_eventService.add(new NewUser_EventDto(businessUserService.getById(id),event));
            if(user_event!=null)
            return ResponseEntity.ok("Success");
            else return ResponseEntity.badRequest().body("Fail to create new Event");
        }
        return ResponseEntity.badRequest().body("User with id: " + id + "npt found");
    }
}
