package com.example.controller;

import com.example.model.event.EventDto;
import com.example.model.event.NewEventDto;
import com.example.model.userEvent.UserEventDto;
import com.example.security.JwtProvider;
import com.example.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/events")
@CrossOrigin(origins="*")
public class EventController {

    private final EventService eventService;
    private final JwtProvider jwtProvider;
    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);

    @Autowired
    public EventController(EventService eventService, JwtProvider jwtProvider) {
        this.eventService = eventService;
        this.jwtProvider = jwtProvider;
    }

    @GetMapping()
    public List<EventDto> getAll(@RequestHeader("Authorization") String token) {
        LOGGER.trace("Enter method: getAll(). Params: {}", token);
        return eventService.getAll();
    }

    @GetMapping("/subscriptions")
    public List<EventDto> getSubscriptions(@RequestHeader("Authorization") String token) {
        LOGGER.trace("Enter method: getAllSubscriptions(). Params: {}", token);
        String stillToken = jwtProvider.resolveToken(token);
        return eventService.getAllByUserId(jwtProvider.getIdFromToken(stillToken));
    }

    @PutMapping
    public EventDto update(@RequestBody EventDto event, @RequestHeader("Authorization") String token) {
        LOGGER.trace("Enter method: update(). Params: {}", token);
        String stillToken = jwtProvider.resolveToken(token);
        return eventService.update(event, jwtProvider.getIdFromToken(stillToken));
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        LOGGER.trace("Enter method: delete(). Params: {}, {}", id, token);
        String stillToken = jwtProvider.resolveToken(token);
        return eventService.delete(id, jwtProvider.getIdFromToken(stillToken));
    }

    @PostMapping
    public EventDto add(@RequestBody NewEventDto newEvent, @RequestHeader("Authorization") String token) {
        LOGGER.trace("Enter method: add(). Params: {}, {}", newEvent, token);
        String stillToken = jwtProvider.resolveToken(token);
        return eventService.add(newEvent, jwtProvider.getIdFromToken(stillToken));
    }

    @PostMapping("/subscribe")
    public EventDto subscribe(@PathParam("eventId") Long eventId, @RequestHeader("Authorization") String token) {
        LOGGER.trace("Enter method: subscribe(). Params: {}, {}", eventId, token);
        String stillToken = jwtProvider.resolveToken(token);
        return eventService.subscribe(eventId, jwtProvider.getIdFromToken(stillToken));
    }

    @DeleteMapping("/unsubscribe")
    public Long unsubscribe(@PathParam("eventId") Long eventId, @RequestHeader("Authorization") String token) {
        LOGGER.trace("Enter method: unsubscribe(). Params: {}, {}", eventId, token);
        String stillToken = jwtProvider.resolveToken(token);
        return eventService.unsubscribe(eventId, jwtProvider.getIdFromToken(stillToken));
    }

    @PutMapping("/add/review")
    public UserEventDto addReview(@PathParam("eventId") Long eventId,
                                  @PathParam("review") String review,
                                  @RequestHeader("Authorization") String token)
    {
        LOGGER.trace("Enter method: addReview(). Params: {}, {}, {}", eventId, review, token);
        String stillToken = jwtProvider.resolveToken(token);
        return eventService.addReview(eventId, review, jwtProvider.getIdFromToken(stillToken));
    }
}
