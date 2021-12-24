package com.example.service;

import com.example.entity.User;
import com.example.exception.UserNotFoundException;
import com.example.model.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

        public User getById(Long id) {
             User userEntity =  userRepository.getById(id);
             if(userEntity == null) {
                 throw new UserNotFoundException("User with id {" + id + "} not found");
             }
             return userEntity;
        }

        public User getByLogin(String login) {
            return userRepository.findByLogin(login);
        }

         public User update(UserDto userDto) {
             if(getById(userDto.getId()) != null) {
                 User userEntity = UserDto.toEntity(userDto);
                 return userRepository.save(userEntity);
             }
             else {
                 throw new UserNotFoundException("User with id {" + userDto.getId() + "} not found");
             }
         }

        public UserDto findByLoginAndPassword(String login, String password) {
            User user = getByLogin(login);
            if (user != null) {
                if (passwordEncoder.matches(password, user.getPassword())) {
                    return UserDto.toDto(user);
                }
            }
            return null;
        }
}
