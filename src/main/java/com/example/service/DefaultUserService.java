package com.example.service;

import com.example.entity.DefaultUser;
import com.example.entity.Role;
import com.example.exception.UniqueLoginException;
import com.example.exception.UserNotFoundException;
import com.example.model.defaultUser.DefaultUserDto;
import com.example.model.defaultUser.NewDefaultUserDto;
import com.example.repository.DefaultUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

    public DefaultUser add(NewDefaultUserDto newDefaultUserDto) {
        if (userService.getByLogin(newDefaultUserDto.getLogin()) != null)
            throw new UniqueLoginException("The login is taken");
        newDefaultUserDto.setPassword(passwordEncoder.encode(newDefaultUserDto.getPassword()));
        DefaultUser defaultUserEntity = NewDefaultUserDto.toEntity(newDefaultUserDto);
        return defaultUserRepository.save(defaultUserEntity);
    }

    public DefaultUser update(DefaultUserDto defaultUserDto) {
        if (getById(defaultUserDto.getId()) == null) throw new UserNotFoundException("User not found");
        if(userService.getByLogin(defaultUserDto.getLogin())!=null) throw new UniqueLoginException("This login is already taken");
        return DefaultUserDto.toEntity(defaultUserDto);
    }

    public DefaultUserDto registerDefaultUser(NewDefaultUserDto newDefaultUserDto) {
        newDefaultUserDto.setRole(Role.USER_DEFAULT);
        return DefaultUserDto.toDto(add(newDefaultUserDto));
    }

}
