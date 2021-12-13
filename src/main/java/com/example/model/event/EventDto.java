package com.example.model.event;

import com.example.entity.Event;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;

public class EventDto {
    private Long id;

    private LocalDate start;

    private LocalDate end;

    private String eventName;

    private String description;

    private long likeCounter;

    private int ageCensor;

    public EventDto(Long id, LocalDate start, LocalDate end, String eventName, String description, long likeCounter, int ageCensor) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.eventName = eventName;
        this.description = description;
        this.likeCounter = likeCounter;
        this.ageCensor = ageCensor;
    }

    public EventDto() {
    }

    public static Event toEntity(EventDto eventDto){
        Event entity=new Event();
        entity.setId(eventDto.getId());
        entity.setStartDate(eventDto.getStart());
        entity.setEndDate(eventDto.getEnd());
        entity.setEventName(eventDto.getEventName());
        entity.setLikeCounter(eventDto.getLikeCounter());
        entity.setAgeCensor(eventDto.getAgeCensor());
        return entity;
    }

    public static EventDto toModel(Event event){
        EventDto eventDto=new EventDto();
        eventDto.setId(event.getId());
        eventDto.setStart(event.getStartDate());
        eventDto.setEnd(event.getEndDate());
        eventDto.setEventName(event.getEventName());
        eventDto.setLikeCounter(event.getLikeCounter());
        eventDto.setAgeCensor(event.getAgeCensor());
        return eventDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
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
