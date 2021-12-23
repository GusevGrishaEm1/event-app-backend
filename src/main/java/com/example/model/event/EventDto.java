package com.example.model.event;

import com.example.entity.Event;
import java.time.LocalDateTime;

public class EventDto {

    private Long id;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String eventName;

    private String description;

    private int ageCensor;

    private long likeCounter;

    public EventDto(Long id, LocalDateTime startDate, LocalDateTime endDate, String eventName, String description, long likeCounter, int ageCensor) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.eventName = eventName;
        this.description = description;
        this.likeCounter = likeCounter;
        this.ageCensor = ageCensor;
    }

    public EventDto() {}

    public static Event toEntity(EventDto eventDto){
        Event eventEntity = new Event();
        eventEntity.setId(eventDto.getId());
        eventEntity.setStartDate(eventDto.getStartDate());
        eventEntity.setEndDate(eventDto.getEndDate());
        eventEntity.setEventName(eventDto.getEventName());
        eventEntity.setDescription(eventDto.getDescription());
        eventEntity.setAgeCensor(eventDto.getAgeCensor());
        eventEntity.setLikeCounter(eventDto.getLikeCounter());
        return eventEntity;
    }

    public static EventDto toDto(Event eventEntity){
        EventDto eventDto = new EventDto();
        eventDto.setId(eventEntity.getId());
        eventDto.setStartDate(eventEntity.getStartDate());
        eventDto.setEndDate(eventEntity.getEndDate());
        eventDto.setEventName(eventEntity.getEventName());
        eventDto.setDescription(eventEntity.getDescription());
        eventDto.setAgeCensor(eventEntity.getAgeCensor());
        eventDto.setLikeCounter(eventEntity.getLikeCounter());
        return eventDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
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
