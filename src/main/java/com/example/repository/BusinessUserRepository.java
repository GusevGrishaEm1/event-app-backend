package com.example.repository;

import com.example.entity.BusinessUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessUserRepository extends JpaRepository<BusinessUser,Long> {
    BusinessUser findByCompanyName(String companyName);
}
