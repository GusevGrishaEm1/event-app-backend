package com.example.service;

import com.example.entity.BusinessUser;
import com.example.entity.Role;
import com.example.exception.UniqueLoginException;
import com.example.model.businessUser.BusinessUserDto;
import com.example.model.businessUser.NewBusinessUserDto;
import com.example.repository.BusinessUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BusinessUserService {

    private final BusinessUserRepository businessUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @Autowired
    public BusinessUserService(BusinessUserRepository businessUserRepository, UserService userService) {
        this.businessUserRepository = businessUserRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.userService = userService;
    }

    public BusinessUser getById(Long id){
        return businessUserRepository.findById(id).get();
    }

    public long delete(Long id){
        businessUserRepository.deleteById(id);
        return id;
    }

    public BusinessUser add(NewBusinessUserDto newBusinessUserDto) {
        if(userService.getByLogin(newBusinessUserDto.getLogin()) == null) {
            newBusinessUserDto.setPassword(passwordEncoder.encode(newBusinessUserDto.getPassword()));
            BusinessUser businessUserEntity = NewBusinessUserDto.toEntity(newBusinessUserDto);
            return businessUserRepository.save(businessUserEntity);
        }
        else {
            throw new UniqueLoginException("The login is taken");
        }
    }

    public BusinessUser update(BusinessUserDto businessUserDto){
        if(getById(businessUserDto.getId())!=null){return  businessUserDto.toEntity(businessUserDto);}
        else {
            //write exc
            return null;
        }
    }

    public BusinessUserDto registerBusinessUser(NewBusinessUserDto newBusinessUserDto) {
        newBusinessUserDto.setRole(Role.USER_BUSINESS);
        return BusinessUserDto.toDto(add(newBusinessUserDto));
    }

}
