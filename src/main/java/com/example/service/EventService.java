package com.example.service;

import com.example.entity.Event;
import com.example.entity.User;
import com.example.entity.UserEvent;
import com.example.exception.EventNotFoundException;
import com.example.exception.UserAccessException;
import com.example.model.event.EventDto;
import com.example.model.event.NewEventDto;
import com.example.model.user_event.UserEventDto;
import com.example.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final UserEventService userEventService;
    private final UserService userService;

    @Autowired
    public EventService(EventRepository eventRepository, UserEventService userEventService, UserService userService) {
        this.eventRepository = eventRepository;
        this.userEventService = userEventService;
        this.userService = userService;
    }

    public EventDto add(NewEventDto eventDto, Long userId) {
        Event eventEntity = NewEventDto.toEntity(eventDto);
        eventEntity = eventRepository.save(eventEntity);
        User userEntity = userService.getById(userId);
        UserEvent userEvent = new UserEvent();
        userEvent.setEvent(eventEntity);
        userEvent.setUser(userEntity);
        userEvent.setOwner(true);
        userEventService.add(userEvent);
        return EventDto.toDto(eventEntity);
    }

    public Long delete(Long id, Long userId) {
        User userEntity = userService.getById(userId);
        Event eventEntity = getById(id);
        UserEvent userEvent = userEventService.getByUserAndEvent(userEntity, eventEntity);
        if(userEvent.getOwner()) {
            eventRepository.deleteById(id);
            return id;
        }
        else {
            throw new UserAccessException("User access exception.");
        }
    }

    public EventDto update(EventDto eventDto, Long userId) {
        User userEntity = userService.getById(userId);
        Event eventEntity = EventDto.toEntity(eventDto);
        UserEvent userEvent = userEventService.getByUserAndEvent(userEntity, eventEntity);
        if(userEvent.getOwner()) {
            return EventDto.toDto(eventRepository.save(eventEntity));
        }
        else {
            throw new UserAccessException("User access exception.");
        }
    }

    public EventDto subscribe(Long eventId, Long userId) {
        Event eventEntity = getById(eventId);
        User userEntity = userService.getById(userId);
        UserEvent userEvent = new UserEvent();
        userEvent.setEvent(eventEntity);
        userEvent.setUser(userEntity);
        userEvent.setOwner(false);
        userEventService.add(userEvent);
        return EventDto.toDto(eventEntity);
    }

    public Long unsubscribe(Long eventId, Long userId) {
        Event eventEntity = getById(eventId);
        User userEntity = userService.getById(userId);
        UserEvent userEvent = userEventService.getByUserAndEvent(userEntity, eventEntity);
        return userEventService.delete(userEvent.getId());
    }

    public UserEventDto addReview(Long eventId, String review, Long userId) {
        Event eventEntity = getById(eventId);
        User userEntity = userService.getById(userId);
        UserEvent userEvent = userEventService.getByUserAndEvent(userEntity, eventEntity);
        if(!userEvent.getOwner()) {
            userEvent.setReview(review);
            userEventService.update(userEvent);
            return UserEventDto.toDto(userEvent);
        }
        else {
            throw new UserAccessException("User access exception.");
        }
    }

    public Event getById(Long id) {
        Event event = eventRepository.getById(id);
        if(event!=null) return event;
        else throw new EventNotFoundException("Event not found.");
    }

    public List<EventDto> getAll() {
        return eventRepository.findAll().stream().map(EventDto::toDto).collect(Collectors.toList());
    }
}
