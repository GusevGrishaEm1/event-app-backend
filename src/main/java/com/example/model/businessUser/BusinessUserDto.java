package com.example.model.businessUser;

import com.example.entity.BusinessUser;

public class BusinessUserDto {
    private Long id;
    private String companyName;
    private String address;

    public BusinessUserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        BusinessUser businessUserEntity=new BusinessUser();
        businessUserEntity.setId(businessUserDto.getId());
        businessUserEntity.setAddress(businessUserDto.getAddress());
        businessUserEntity.setCompanyName(businessUserDto.getCompanyName());
        return businessUserEntity;
    }

    public static BusinessUserDto toDto(BusinessUser businessUser){
        BusinessUserDto businessUserDto=new BusinessUserDto();
        businessUserDto.setId(businessUser.getId());
        businessUserDto.setAddress(businessUser.getAddress());
        businessUserDto.setCompanyName(businessUser.getCompanyName());
        return businessUserDto;
    }
}
