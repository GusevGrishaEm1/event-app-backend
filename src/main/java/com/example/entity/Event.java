package com.example.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="event")
public class Event {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="startDate")
    private LocalDate startDate;

    @Column(name = "endDate")
    private LocalDate endDate;

    @Column(name="eventName")
    private String eventName;

    @Column(name="description")
    private String description;

    @Column(name="likeCounter")
    private long likeCounter;

    @Column(name="ageCensor")
    private int ageCensor;


    public Event() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getLikeCounter() {
        return likeCounter;
    }

    public void setLikeCounter(Long likeCounter) {
        this.likeCounter = likeCounter;
    }

    public int getAgeCensor() {
        return ageCensor;
    }

    public void setAgeCensor(int ageCensor) {
        this.ageCensor = ageCensor;
    }
}
