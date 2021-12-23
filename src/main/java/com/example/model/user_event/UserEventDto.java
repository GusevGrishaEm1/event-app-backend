package com.example.model.user_event;

import com.example.entity.Event;
import com.example.entity.User;

public class UserEventDto {

    private Long id;

    private User user;

    private Event event;

    public UserEventDto(Long id, User user, Event event) {
        this.id = id;
        this.user = user;
        this.event = event;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
