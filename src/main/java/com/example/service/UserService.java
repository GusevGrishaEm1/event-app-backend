package com.example.service;

import com.example.model.User;
import com.example.model.dto.NewUserDto;
import com.example.model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.UserRepository;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

        public User getById(Long id) {
            return userRepository.findById(id).get();
        }

        public Long delete(Long id) {
            userRepository.deleteById(id);
            return id;
        }

         public User add(NewUserDto userDto) {
            User user = new User();
            user.setLogin(userDto.getLogin());
            user.setPassword(userDto.getPassword());
            user.setCityName(userDto.getCityName());
            return userRepository.save(user);
         }

         public User update(UserDto userDto) {
             User user = new User();
             user.setId(userDto.getId());
             user.setLogin(userDto.getLogin());
             user.setPassword(userDto.getPassword());
             user.setCityName(userDto.getCityName());
             return userRepository.save(user);
         }

         public List<User> getAll() {
             return userRepository.findAll();
         }
}
