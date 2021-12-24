package com.example.repository;

import com.example.entity.Event;
import com.example.entity.User;
import com.example.entity.UserEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEventRepository extends JpaRepository<UserEvent, Long> {
    UserEvent findByUserAndEvent(User user, Event event);
    UserEvent findByEventAndOwner(Event event, Boolean owner);
}
