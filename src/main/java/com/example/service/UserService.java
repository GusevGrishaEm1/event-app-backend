package com.example.service;

import com.example.entity.User;
import com.example.exception.UserNotFoundException;
import com.example.model.user.UserDto;
import com.example.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User getById(Long id) {
        User user =  userRepository.getById(id);
        if (user != null) return user;
        else throw new UserNotFoundException("User with  id {" + id + "} not found.");
    }

    public User getByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public UserDto findByLoginAndPassword(String login, String password) {
        User user = getByLogin(login);
        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                LOGGER.debug("Successful login.");
                return UserDto.toDto(user);
            }
        }
        LOGGER.error("User with  login and password [{} and {}] not found.", login, password);
        throw new UserNotFoundException("User with  login and password {" + login +" and " + password + "} not found.");
    }


}
