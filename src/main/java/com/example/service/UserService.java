package com.example.service;

import com.example.entity.User;
import com.example.exception.UserNotFoundException;
import com.example.model.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
             Optional<User> optionalUser =  userRepository.findById(id);
             User user = optionalUser.orElse(null);
             if(user==null) {
                 throw new UserNotFoundException("User with id {" + id + "} not found");
             }
             return user;
        }

        public Long delete(Long id) {
            userRepository.deleteById(id);
            return id;
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

         public List<UserDto> getAll() {
             return userRepository.findAll().stream().map(UserDto::toDto).collect(Collectors.toList());
         }

        public User findByLoginAndPassword(String login, String password) {
            User user = getByLogin(login);
            if (user != null) {
                if (passwordEncoder.matches(password, user.getPassword())) {
                    return user;
                }
            }
            return null;
        }

}
