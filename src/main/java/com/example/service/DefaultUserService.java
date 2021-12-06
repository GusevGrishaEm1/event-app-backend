package com.example.service;

import com.example.entity.DefaultUser;
import com.example.model.defaultUser.DefaultUserDto;
import com.example.model.defaultUser.NewDefaultUserDto;
import com.example.repository.DefaultUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DefaultUserService {

    private final DefaultUserRepository defaultUserRepository;

    @Autowired
    public DefaultUserService(DefaultUserRepository defaultUserRepository) {
        this.defaultUserRepository = defaultUserRepository;
    }

    public DefaultUser getById(Long id) {
        return defaultUserRepository.findById(id).get();
    }

    public long delete(Long id) {
        defaultUserRepository.deleteById(id);
        return id;
    }

    public DefaultUser getByUsername(String userName) {
        return defaultUserRepository.findByUsername(userName);
    }

    public DefaultUser add(NewDefaultUserDto newDefaultUserDto) {
        try {
            //проверка на уникальность?
            return newDefaultUserDto.toEntity(newDefaultUserDto);
        } catch (Exception e) {
            // write exc
            return null;
        }
    }

    public DefaultUser update(DefaultUserDto defaultUserDto) {
        if (getById(defaultUserDto.getId()) != null) {
            return DefaultUserDto.toEntity(defaultUserDto);
        } else {
            // exc
            return null;
        }
    }

    public List<DefaultUser> getAll() {
        return defaultUserRepository.findAll();
    }



}
