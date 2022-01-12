package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name="usr_event")
public class UserEvent {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usr_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(name = "owner")
    private Boolean owner;

    @Column(name = "review")
    private String review;

    public UserEvent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Boolean getOwner() {
        return owner;
    }

    public void setOwner(Boolean owner) {
        this.owner = owner;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "UserEvent{" +
                "id=" + id +
                ", user=" + user +
                ", event=" + event +
                ", owner=" + owner +
                ", review='" + review + '\'' +
                '}';
    }
}
