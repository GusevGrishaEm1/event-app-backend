package com.example.model.user_event;

import com.example.entity.Event;
import com.example.entity.User;
import com.example.entity.User_Event;

import java.util.List;

public class NewUser_EventDto {

    private User user;

    private Event event;

    public NewUser_EventDto(User user, Event event) {
        this.user = user;
        this.event = event;
    }

    public static User_Event toEntity(NewUser_EventDto eventDto){
        User_Event entity=new User_Event();
        entity.setEvent(eventDto.getEvent());
        entity.setUser(eventDto.getUser());
        return entity;
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
