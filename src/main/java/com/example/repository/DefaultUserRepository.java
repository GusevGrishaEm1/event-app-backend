package com.example.repository;

import com.example.entity.DefaultUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefaultUserRepository extends JpaRepository<DefaultUser, Long> {
}
