package com.example.init.datasource;

import com.example.entity.Role;
import com.example.model.businessUser.BusinessUserDto;
import com.example.model.businessUser.NewBusinessUserDto;
import com.example.model.event.NewEventDto;
import com.example.service.BusinessUserService;
import com.example.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Component
public class InitDatasource {


    private final EventService eventService;
    private final BusinessUserService businessUserService;

    @Autowired
    public InitDatasource(EventService eventService, BusinessUserService businessUserService) {
        this.eventService = eventService;
        this.businessUserService = businessUserService;
    }

    @PostConstruct
    public void init() {
        BusinessUserDto businessUserDto = businessUserService.save(new NewBusinessUserDto("business_user_2000", "business_user_2000", Role.USER_BUSINESS, "Company", "Самара"));
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18),
                businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18),
                businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());

        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());

        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());
        eventService.add(
                new NewEventDto(LocalDateTime.now(), LocalDateTime.now().plusDays(5),
                        "event_name", "Россия, Самара, улица Карбышева, 69", "event_description", 0, 18), businessUserDto.getId());


    }
}
