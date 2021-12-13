package com.example.model.event;


import com.example.entity.Event;

import java.time.LocalDate;

public class NewEventDto {

    private LocalDate startDate;

    private LocalDate endDate;

    private String eventName;

    private String description;

    private long likeCounter;

    private int ageCensor;

    public NewEventDto(LocalDate startDate, LocalDate endDate, String eventName, String description, long likeCounter, int ageCensor) {
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getLikeCounter() {
        return likeCounter;
    }

    public void setLikeCounter(long likeCounter) {
        this.likeCounter = likeCounter;
    }

    public int getAgeCensor() {
        return ageCensor;
    }

    public void setAgeCensor(int ageCensor) {
        this.ageCensor = ageCensor;
    }
}
