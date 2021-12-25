package com.example.service;

import com.example.entity.Event;
import com.example.entity.User;
import com.example.entity.UserEvent;
import com.example.repository.UserEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEventService {
    private final UserEventRepository userEventRepository;

    @Autowired
    public UserEventService(UserEventRepository userEventRepository) {
        this.userEventRepository = userEventRepository;
    }

    public UserEvent add(UserEvent userEvent) {
        return userEventRepository.save(userEvent);
    }

    public Long delete(long id) {
        userEventRepository.deleteById(id);
        return id;
    }
    public UserEvent update(UserEvent userEvent) {
        return userEventRepository.save(userEvent);
    }
    public UserEvent getByUserAndEvent(User user, Event event) {
        return userEventRepository.findByUserAndEvent(user, event);
    }

    public List<UserEvent> getEventsByUserId(Long userId){
        return userEventRepository.findUserEventsByUser_Id(userId);
    }
}
