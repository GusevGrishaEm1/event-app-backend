package com.example.service;

import com.example.entity.Event;
import com.example.model.event.EventDto;
import com.example.model.event.NewEventDto;
import com.example.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event add(NewEventDto eventDto){
        return eventRepository.save(NewEventDto.toEntity(eventDto));
    }

    public Long remove(Long id){
        eventRepository.deleteById(id);
        return id;
    }

    public Event getById(long id){
        return eventRepository.getById(id);
    }

    public Event update(EventDto eventDto){
        if(getById(eventDto.getId())!=null) return EventDto.toEntity(eventDto);
        else return null;
    }
}
