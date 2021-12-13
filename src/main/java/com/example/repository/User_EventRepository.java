package com.example.repository;

import com.example.entity.User_Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_EventRepository extends JpaRepository<User_Event, Long> {
}
