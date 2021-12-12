package com.example.model.businessUser;

import com.example.entity.BusinessUser;
import com.example.entity.Role;
import com.example.model.user.NewUserDto;

public class NewBusinessUserDto extends NewUserDto {

    private final String companyName;
    private final String address;

    public NewBusinessUserDto(String login, String password, Role role, String companyName, String address) {
        super(login, password, role);
        this.companyName = companyName;
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }

    public static BusinessUser toEntity(NewBusinessUserDto newBusinessUserDto){
        BusinessUser businessUserEntity = new BusinessUser();
        businessUserEntity.setLogin(newBusinessUserDto.getLogin());
        businessUserEntity.setPassword(newBusinessUserDto.getPassword());
        businessUserEntity.setRole(newBusinessUserDto.getRole());
        businessUserEntity.setCompanyName(newBusinessUserDto.getCompanyName());
        businessUserEntity.setAddress(newBusinessUserDto.getAddress());
        return businessUserEntity;
    }
}
