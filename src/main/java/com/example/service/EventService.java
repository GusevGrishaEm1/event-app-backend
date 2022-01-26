package com.example.service;

import com.example.entity.DefaultUser;
import com.example.entity.Event;
import com.example.entity.User;
import com.example.entity.UserEvent;
import com.example.exception.EventDateException;
import com.example.exception.EventNotFoundException;
import com.example.exception.UserAccessException;
import com.example.model.event.EventDto;
import com.example.model.event.NewEventDto;
import com.example.model.review.ReviewDto;
import com.example.model.userEvent.UserEventDto;
import com.example.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final UserEventService userEventService;
    private final UserService userService;
    private final DefaultUserService defaultUserService;
    private static final Logger LOGGER = LoggerFactory.getLogger(EventService.class);

    @Autowired
    public EventService(EventRepository eventRepository, UserEventService userEventService, UserService userService, DefaultUserService defaultUserService) {
        this.eventRepository = eventRepository;
        this.userEventService = userEventService;
        this.userService = userService;
        this.defaultUserService = defaultUserService;
    }

    public EventDto add(NewEventDto eventDto, Long userId) {
        if (!eventDto.getStartDate().isBefore(eventDto.getEndDate())) throw new EventDateException();
        Event eventEntity = NewEventDto.toEntity(eventDto);
        eventEntity = eventRepository.save(eventEntity);
        User userEntity = userService.getById(userId);
        UserEvent userEvent = new UserEvent();
        userEvent.setEvent(eventEntity);
        userEvent.setUser(userEntity);
        userEvent.setOwner(true);
        userEventService.add(userEvent);
        LOGGER.debug("Add event {}", eventEntity);
        return EventDto.toDto(eventEntity);
    }

    public Long delete(Long id, Long userId) {
        User userEntity = userService.getById(userId);
        Event eventEntity = getById(id);
        if(eventEntity==null) throw new EventNotFoundException("Event not found.");
        UserEvent userEvent = userEventService.getByUserAndEvent(userEntity, eventEntity);
        if (userEvent == null || !userEvent.getOwner()) throw new UserAccessException("User access exception.");
        List<UserEvent> userEvents = userEventService.getByEvent(eventEntity);
        userEvents.forEach(p -> userEventService.delete(p.getId()));
        eventRepository.deleteById(id);
        LOGGER.debug("Delete event with id {}", id);
        return id;
    }

    public EventDto update(EventDto eventDto, Long userId) {
        User userEntity = userService.getById(userId);
        if (!eventDto.getStartDate().isBefore(eventDto.getEndDate())) throw new EventDateException();
        Event eventEntity = EventDto.toEntity(eventDto);
        UserEvent userEvent = userEventService.getByUserAndEvent(userEntity, eventEntity);
        if (userEvent == null || !userEvent.getOwner()) throw new UserAccessException("User access exception.");
        LOGGER.debug("Update event {}", eventEntity);
        return EventDto.toDto(eventRepository.save(eventEntity));
    }

    public EventDto subscribe(Long eventId, Long userId) {
        Event eventEntity = getById(eventId);
        DefaultUser defaultUserEntity = defaultUserService.getById(userId);
        if(userEventService.getByUserAndEvent(defaultUserEntity, eventEntity) != null &&
                (LocalDate.now().getYear() - defaultUserEntity.getBDay().getYear()) < eventEntity.getAgeCensor())
            throw new UserAccessException("User access exception.");
        UserEvent userEvent = new UserEvent();
        eventEntity.setLikeCounter(eventEntity.getLikeCounter()+1);
        eventRepository.save(eventEntity);
        userEvent.setEvent(eventEntity);
        userEvent.setUser(defaultUserEntity);
        userEvent.setOwner(false);
        userEventService.add(userEvent);
        LOGGER.debug("Subscribe default user {} to event {}", defaultUserEntity, eventEntity);
        return EventDto.toDto(eventEntity);
    }

    public Long unsubscribe(Long eventId, Long userId) {
        Event eventEntity = getById(eventId);
        User userEntity = userService.getById(userId);
        eventEntity.setLikeCounter(eventEntity.getLikeCounter()-1);
        eventRepository.save(eventEntity);
        UserEvent userEvent = userEventService.getByUserAndEvent(userEntity, eventEntity);
        LOGGER.debug("Unsubscribe user {} from event {}", userEntity, eventEntity);
        return userEventService.delete(userEvent.getId());
    }

    public UserEventDto addReview(Long eventId, String review, Long userId) {
        Event eventEntity = getById(eventId);
        User userEntity = userService.getById(userId);
        UserEvent userEvent = userEventService.getByUserAndEvent(userEntity, eventEntity);
        if(userEvent != null && !userEvent.getOwner()) {
            userEvent.setReview(review);
            userEventService.update(userEvent);
            LOGGER.debug("Add review {} to event {}", review, eventEntity);
            return UserEventDto.toDto(userEvent);
        }
        else {
            throw new UserAccessException("User access exception.");
        }
    }

    public List<ReviewDto> getReviews(Long eventId) {
        Event event = getById(eventId);
        List <ReviewDto> reviews = new ArrayList<>();
        List <UserEvent> usersAndEvents = userEventService.getByReviewNotNull(event);
        usersAndEvents.forEach(item -> reviews.add(new ReviewDto(item.getUser().getId(), defaultUserService.getById(item.getUser().getId()).getUsername(), item.getReview())));
        return reviews;
    }

    public EventDto like(Long eventId, Long userId) {
        return  null;
    }

    public Event getById(Long id) {
        Event event = eventRepository.getById(id);
        if (event != null) return event;
        else throw new EventNotFoundException("Event with id {"+ id +"} not found.");
    }

    public List<EventDto> getAll() {
        return eventRepository.findAll().stream().map(EventDto::toDto).collect(Collectors.toList());
    }

    public List<EventDto> getAllByUserId(long userId){
        List<UserEvent> userEvents = userEventService.getEventsByUserId(userId);
        List<EventDto> res = new LinkedList<>();
        for (UserEvent ue:
                userEvents) {
            res.add(EventDto.toDto(ue.getEvent()));
        }
        return res;
    }

    public List<EventDto> getAllByKeyword(String keyword) {
        List<EventDto> events = getAll();
        LOGGER.debug("Filter events by keyword {}", keyword);
        return events.stream().filter(event -> event.getDescription().toLowerCase(Locale.ROOT).contains(keyword.toLowerCase(Locale.ROOT))).collect(Collectors.toList());
    }
}
