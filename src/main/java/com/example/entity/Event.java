package com.example.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="event")
public class Event {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="eventName")
    private String eventName;

    @Column(name="description")
    private String description;

    @Column(name="startDate")
    private LocalDateTime startDate;

    @Column(name = "endDate")
    private LocalDateTime endDate;

    @Column(name="address")
    private String address;

    @Column(name="likeCounter")
    private Long likeCounter;

    @Column(name="ageCensor")
    private Integer ageCensor;

    public Event() {}

    public Long getId() {return id;}

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", eventName='" + eventName + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", address='" + address + '\'' +
                ", likeCounter=" + likeCounter +
                ", ageCensor=" + ageCensor +
                '}';
    }
}
