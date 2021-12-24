package com.example.model.event;

import com.example.entity.Event;
import java.time.LocalDateTime;

public class NewEventDto {

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String eventName;

    private String description;

    private int ageCensor;

    private long likeCounter;

    public NewEventDto(LocalDateTime startDate, LocalDateTime endDate, String eventName, String description, long likeCounter, int ageCensor) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.eventName = eventName;
        this.description = description;
        this.likeCounter = likeCounter;
        this.ageCensor = ageCensor;
    }

    public static Event toEntity(NewEventDto eventDto){
        Event entity=new Event();
        entity.setStartDate(eventDto.getStartDate());
        entity.setEndDate(eventDto.getEndDate());
        entity.setEventName(eventDto.getEventName());
        entity.setLikeCounter(eventDto.getLikeCounter());
        entity.setAgeCensor(eventDto.getAgeCensor());
        entity.setDescription(eventDto.getDescription());
        return entity;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public String getEventName() {
        return eventName;
    }

    public String getDescription() {
        return description;
    }

    public long getLikeCounter() {
        return likeCounter;
    }

    public int getAgeCensor() {
        return ageCensor;
    }

}
