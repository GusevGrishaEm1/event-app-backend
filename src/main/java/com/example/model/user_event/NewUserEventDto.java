package com.example.model.user_event;

import com.example.entity.Event;
import com.example.entity.User;
import com.example.entity.UserEvent;

public class NewUserEventDto {

    private Long userId;

    private Long eventId;

    private boolean owner;

   // public NewUserEventDto(Long userId, Long eventId) {
   //     this.userId = userId;
   //     this.eventId = eventId;
   // }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public static UserEvent toEntity(NewUserEventDto newUserEventDto, User user, Event event) {
        UserEvent newUserEventEntity = new UserEvent();
        newUserEventEntity.setEvent(event);
        newUserEventEntity.setUser(user);
        return newUserEventEntity;
    }

}
