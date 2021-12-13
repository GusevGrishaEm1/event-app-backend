package com.example.service;

import com.example.entity.User_Event;
import com.example.model.user_event.NewUser_EventDto;
import com.example.repository.User_EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class User_EventService {
    private final User_EventRepository repo;

    @Autowired
    public User_EventService(User_EventRepository repo) {
        this.repo = repo;
    }

    public User_Event add(NewUser_EventDto newUser_eventDto){
        return repo.save(newUser_eventDto.toEntity(newUser_eventDto));
    }

    public long remove(long id){
        repo.deleteById(id);
        return id;
    }
}
