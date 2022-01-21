package com.example.model.event;

import com.example.entity.Event;
import java.time.LocalDateTime;

public class NewEventDto {

    private final LocalDateTime startDate;

    private final LocalDateTime endDate;

    private final String eventName;

    private final String address;

    private final String description;

    private final int ageCensor;

    private final long likeCounter;

    public NewEventDto(LocalDateTime startDate, LocalDateTime endDate, String eventName, String address, String description, long likeCounter, int ageCensor) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.eventName = eventName;
        this.address = address;
        this.description = description;
        this.likeCounter = likeCounter;
        this.ageCensor = ageCensor;
    }

    public static Event toEntity(NewEventDto eventDto){
        Event eventEntity = new Event();
        eventEntity.setStartDate(eventDto.getStartDate());
        eventEntity.setEndDate(eventDto.getEndDate());
        eventEntity.setEventName(eventDto.getEventName());
        eventEntity.setAddress(eventDto.getAddress());
        eventEntity.setLikeCounter(eventDto.getLikeCounter());
        eventEntity.setAgeCensor(eventDto.getAgeCensor());
        eventEntity.setDescription(eventDto.getDescription());
        return eventEntity;
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

    public String getAddress() {
        return address;
    }
}
