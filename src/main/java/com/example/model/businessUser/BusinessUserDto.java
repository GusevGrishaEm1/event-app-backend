package com.example.model.businessUser;

import com.example.entity.BusinessUser;
import com.example.model.user.UserDto;

public class BusinessUserDto extends UserDto {

    private String companyName;
    private String address;

    public BusinessUserDto() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static BusinessUser toEntity(BusinessUserDto businessUserDto){
        BusinessUser businessUserEntity = new BusinessUser();
        businessUserEntity.setId(businessUserDto.getId());
        businessUserEntity.setLogin(businessUserDto.getLogin());
        businessUserDto.setPassword(businessUserDto.getPassword());
        businessUserDto.setRole(businessUserDto.getRole());
        businessUserEntity.setAddress(businessUserDto.getAddress());
        businessUserEntity.setCompanyName(businessUserDto.getCompanyName());
        return businessUserEntity;
    }

    public static BusinessUserDto toDto(BusinessUser businessUserEntity){
        BusinessUserDto businessUserDto = new BusinessUserDto();
        businessUserDto.setId(businessUserEntity.getId());
        businessUserDto.setLogin(businessUserEntity.getLogin());
        businessUserDto.setPassword(businessUserEntity.getPassword());
        businessUserDto.setRole(businessUserEntity.getRole());
        businessUserDto.setAddress(businessUserEntity.getAddress());
        businessUserDto.setCompanyName(businessUserEntity.getCompanyName());
        return businessUserDto;
    }

    @Override
    public String toString() {
        return "BusinessUserDto{" +
                "id=" + getId() + '\'' +
                ", login='" + getLogin() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", role=" + getRole() + '\'' +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
