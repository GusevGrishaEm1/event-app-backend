package com.example.model.businessUser;

import com.example.entity.BusinessUser;


public class NewBusinessUserDto {
    private String companyName;
    private String address;

    public NewBusinessUserDto(String companyName, String address) {
        this.companyName = companyName;
        this.address = address;
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

    public static BusinessUser toEntity(NewBusinessUserDto newBusinessUserDto){
        BusinessUser businessUser=new BusinessUser();
        businessUser.setCompanyName(newBusinessUserDto.getCompanyName());
        businessUser.setAddress(newBusinessUserDto.getAddress());
        return businessUser;
    }
}
