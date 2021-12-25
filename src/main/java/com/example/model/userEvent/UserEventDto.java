package com.example.model.userEvent;

import com.example.entity.UserEvent;

public class UserEventDto {

    private Long id;

    private Long userId;

    private Long eventId;

    private String review;

    private Boolean liked;

    private Boolean owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }

    public Boolean getOwner() {
        return owner;
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
        userEventDto.setLiked(userEventEntity.getLiked());
        return userEventDto;
    }
}
