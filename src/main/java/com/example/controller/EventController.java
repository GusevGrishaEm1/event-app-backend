package com.example.controller;

import com.example.model.event.EventDto;
import com.example.model.event.NewEventDto;
import com.example.model.user_event.UserEventDto;
import com.example.security.JwtProvider;
import com.example.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;
    private final JwtProvider jwtProvider;

    @Autowired
    public EventController(EventService eventService, JwtProvider jwtProvider) {
        this.eventService = eventService;
        this.jwtProvider = jwtProvider;
    }

    @GetMapping
    public List<EventDto> getAll() {
        return eventService.getAll();
    }

    @PutMapping
    public EventDto update(@RequestBody EventDto event, @RequestHeader("Authorization") String token) {
        String stillToken = jwtProvider.resolveToken(token);
        return eventService.update(event, jwtProvider.getIdFromToken(stillToken));
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        String stillToken = jwtProvider.resolveToken(token);
        return eventService.delete(id, jwtProvider.getIdFromToken(stillToken));
    }

    @PostMapping
    public EventDto add(@RequestBody NewEventDto event, @RequestHeader("Authorization") String token) {
        String stillToken = jwtProvider.resolveToken(token);
        return eventService.add(event, jwtProvider.getIdFromToken(stillToken));
    }

    /*
    @PostMapping("/{id}/newEvent")
    public ResponseEntity addEvent(@RequestBody NewEventDto newEventDto, @RequestParam Long userId) {
        if (businessUserService.getById(id) != null) {
            EventDto event = eventService.add(newEventDto);
            UserEvent user_event = userEventService.add(new NewUserEventDto(id, event.getId()));
            if(user_event!=null)
            return ResponseEntity.ok("Success");
            else return ResponseEntity.badRequest().body("Failed to create new Event");
        }
        return ResponseEntity.badRequest().body("User with id: " + id + "not found");
    }
    */

    @PutMapping("/subscribe")
    public EventDto subscribe(@PathParam("eventId") Long eventId, @RequestHeader("Authorization") String token) {
        String stillToken = jwtProvider.resolveToken(token);
        return eventService.subscribe(eventId, jwtProvider.getIdFromToken(stillToken));
    }

    @PutMapping("/unsubscribe")
    public Long unsubscribe(@PathParam("eventId") Long eventId, @RequestHeader("Authorization") String token) {
        String stillToken = jwtProvider.resolveToken(token);
        return eventService.unsubscribe(eventId, jwtProvider.getIdFromToken(stillToken));
    }

    @PutMapping("/add/review")
    public UserEventDto addReview(@PathParam("eventId") Long eventId, @RequestBody String review, @RequestHeader("Authorization") String token) {
        String stillToken = jwtProvider.resolveToken(token);
        return eventService.addReview(eventId, review, jwtProvider.getIdFromToken(stillToken));
    }


}