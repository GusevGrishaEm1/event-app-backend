package com.example.service;

import com.example.entity.User;
import com.example.entity.Role;
import com.example.exception.UniqueLoginException;
import com.example.exception.UserNotFoundException;
import com.example.model.account.NewUserDto;
import com.example.model.account.UserDto;
import com.example.model.auth.AuthDto;
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
            User user = userRepository.findByLogin(login);
            if(user != null) {
                return user;
            }
            else {
                return null;
            }
        }

         public User add(NewUserDto newUserDto) {
            if(getByLogin(newUserDto.getLogin()) == null) {
                newUserDto.setPassword(passwordEncoder.encode(newUserDto.getPassword()));
                User userEntity = NewUserDto.toEntity(newUserDto);
                return userRepository.save(userEntity);
            }
            else {
                throw new UniqueLoginException("The login is taken");
            }
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

    public UserDto registerDefaultUser(AuthDto auth) {
        NewUserDto newAccount = new NewUserDto(auth.getLogin(), auth.getPassword(), Role.USER_DEFAULT);
        return UserDto.toDto(add(newAccount));
    }

    public UserDto registerBusinessUser(AuthDto auth) {
        NewUserDto newAccount = new NewUserDto(auth.getLogin(), auth.getPassword(), Role.USER_BUSINESS);
        return UserDto.toDto(add(newAccount));
    }
}
