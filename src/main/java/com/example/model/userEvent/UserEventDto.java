package com.example.model.userEvent;

import com.example.entity.UserEvent;

public class UserEventDto {

    private Long id;

    private Long userId;

    private Long eventId;

    private String review;

    private Boolean owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setOwner(Boolean owner) {
        this.owner = owner;
    }

    public static UserEventDto toDto(UserEvent userEventEntity) {
        UserEventDto userEventDto = new UserEventDto();
        userEventDto.setUserId(userEventEntity.getUser().getId());
        userEventDto.setEventId(userEventEntity.getEvent().getId());
        userEventDto.setOwner(userEventEntity.getOwner());
        userEventDto.setReview(userEventEntity.getReview());
        return userEventDto;
    }

    @Override
    public String toString() {
        return "UserEventDto{" +
                "id=" + id +
                ", userId=" + userId +
                ", eventId=" + eventId +
                ", review='" + review + '\'' +
                ", owner=" + owner +
                '}';
    }
}
