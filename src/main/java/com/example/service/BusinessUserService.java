package com.example.service;

import com.example.entity.BusinessUser;
import com.example.entity.Role;
import com.example.exception.UniqueLoginException;
import com.example.exception.UserNotFoundException;
import com.example.model.businessUser.BusinessUserDto;
import com.example.model.businessUser.NewBusinessUserDto;
import com.example.repository.BusinessUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BusinessUserService {

    private final BusinessUserRepository businessUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultUserService.class);

    @Autowired
    public BusinessUserService(BusinessUserRepository businessUserRepository, UserService userService) {
        this.businessUserRepository = businessUserRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.userService = userService;
    }

    public BusinessUser getById(Long id) {
        return businessUserRepository.getById(id);
    }

    public BusinessUser add(NewBusinessUserDto newBusinessUserDto) {
        if (userService.getByLogin(newBusinessUserDto.getLogin()) != null)
            throw new UniqueLoginException("The login is taken");
        newBusinessUserDto.setPassword(passwordEncoder.encode(newBusinessUserDto.getPassword()));
        BusinessUser businessUserEntity = NewBusinessUserDto.toEntity(newBusinessUserDto);
        LOGGER.debug("Add business user: {}" + businessUserEntity);
        return businessUserRepository.save(businessUserEntity);
    }

    public BusinessUserDto update(BusinessUserDto businessUserDto) {
        if (getById(businessUserDto.getId()) == null) throw new UserNotFoundException("User not found");
        BusinessUser businessUser = businessUserRepository.save(businessUserDto.toEntity(businessUserDto));
        return businessUserDto.toDto(businessUser);
    }

    public BusinessUserDto registerBusinessUser(NewBusinessUserDto newBusinessUserDto) {
        newBusinessUserDto.setRole(Role.USER_BUSINESS);
        return BusinessUserDto.toDto(add(newBusinessUserDto));
    }

}
