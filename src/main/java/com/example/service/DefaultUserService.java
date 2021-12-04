package com.example.service;

import com.example.repository.DefaultUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService {
    private DefaultUserRepository defaultUserRepository;

    @Autowired
    public DefaultUserService(DefaultUserRepository defaultUserRepository) {
        this.defaultUserRepository = defaultUserRepository;
    }


}
