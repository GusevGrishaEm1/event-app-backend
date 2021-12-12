package com.example.service;

import com.example.entity.DefaultUser;
import com.example.entity.Role;
import com.example.exception.UniqueLoginException;
import com.example.model.defaultUser.DefaultUserDto;
import com.example.model.defaultUser.NewDefaultUserDto;
import com.example.repository.DefaultUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DefaultUserService {

    private final DefaultUserRepository defaultUserRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DefaultUserService(DefaultUserRepository defaultUserRepository, UserService userService) {
        this.defaultUserRepository = defaultUserRepository;
        this.userService = userService;
        this.passwordEncoder = new BCryptPasswordEncoder();
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
        if(userService.getByLogin(newDefaultUserDto.getLogin()) == null) {
            newDefaultUserDto.setPassword(passwordEncoder.encode(newDefaultUserDto.getPassword()));
            DefaultUser defaultUserEntity = NewDefaultUserDto.toEntity(newDefaultUserDto);
            return defaultUserRepository.save(defaultUserEntity);
        }
        else {
            throw new UniqueLoginException("The login is taken");
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

    public DefaultUserDto registerDefaultUser(NewDefaultUserDto newDefaultUserDto) {
        newDefaultUserDto.setRole(Role.USER_DEFAULT);
        return DefaultUserDto.toDto(add(newDefaultUserDto));
    }

}
