package com.example.repository;

import com.example.entity.Event;
import com.example.entity.User;
import com.example.entity.UserEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserEventRepository extends JpaRepository<UserEvent, Long> {
    UserEvent findByUserAndEvent(User user, Event event);
    List<UserEvent> findByEvent(Event event);
    UserEvent findByEventAndOwner(Event event, Boolean owner);
    List<UserEvent> findUserEventsByUser_Id(Long id);
    List<UserEvent> findByReviewNotNullAndEvent(Event event);
}
