package com.example.service;

import com.example.entity.BusinessUser;
import com.example.model.businessUser.BusinessUserDto;
import com.example.model.businessUser.NewBusinessUserDto;
import com.example.repository.BusinessUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BusinessUserService {

    private final BusinessUserRepository businessUserRepository;

    @Autowired
    public BusinessUserService(BusinessUserRepository businessUserRepository) {
        this.businessUserRepository=businessUserRepository;
    }

    public BusinessUser getById(Long id){
        return businessUserRepository.findById(id).get();
    }

    public long delete(Long id){
        businessUserRepository.deleteById(id);
        return id;
    }

    public BusinessUser getByCompanyName(String companyName){
        return businessUserRepository.findByCompanyName(companyName);
    }

    public BusinessUser add(NewBusinessUserDto newBusinessUserDto){
        try{
            return newBusinessUserDto.toEntity(newBusinessUserDto);
        }
        catch (Exception e){
            //write exc
            return null;
        }
    }

    public BusinessUser upate(BusinessUserDto businessUserDto){
        if(getById(businessUserDto.getId())!=null){return  businessUserDto.toEntity(businessUserDto);}
        else {
            //write exc
            return null;
        }
    }

    public List<BusinessUser> getAll(){
        return businessUserRepository.findAll();
    }
}
