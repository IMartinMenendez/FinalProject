package com.ironhack.eventservice.services.Impl;

import com.ironhack.eventservice.controller.dto.EventRequest;
import com.ironhack.eventservice.controller.dto.EventResponse;
import com.ironhack.eventservice.models.Event;
import com.ironhack.eventservice.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    public List<EventResponse> getAllEvents(){
        List<Event> events = eventRepository.findAll();
        List<EventResponse> eventResponses = new ArrayList<>();
        for (Event event : events) {
            new EventResponse(event.getType(), event.getDate(), event.getPlace(), event.getTitle(), event.getDescription(), event.getCreator(), event.getAttendees(),  event.getPicture());
        }
        return eventResponses;
    }

    public EventResponse getEventById(Long id) throws Exception {
        Optional<Event> maybeEvent = eventRepository.findById(id);
        if (maybeEvent.isEmpty()) {
            throw new Exception("No Event found");
        }
        return new EventResponse(maybeEvent.get().getType(), maybeEvent.get().getDate(), maybeEvent.get().getPlace(), maybeEvent.get().getTitle(), maybeEvent.get().getDescription(), maybeEvent.get().getCreator(),maybeEvent.get().getAttendees(), maybeEvent.get().getPicture());
    }

    public List<EventResponse> getEventByUserId(Long id){
        List<Event> events = eventRepository.getEventByUser(id);
        List<EventResponse> courseResponses = new ArrayList<>();
        for (Event event : events) {
            new EventResponse(event.getType(), event.getDate(), event.getPlace(), event.getTitle(), event.getDescription(), event.getCreator(), event.getAttendees(),  event.getPicture());
        }
        return courseResponses;
    }

    public void deleteEvent(Long id) throws Exception {
        Optional<Event> maybeEvent = eventRepository.findById(id);
        if(maybeEvent.isEmpty()){
            throw new Exception("No Event found");
        }
        eventRepository.delete(maybeEvent.get());
    }

    public void updateEvent(Long id, EventRequest eventRequest) throws Exception {
        Optional<Event> maybeCourse = eventRepository.findById(id);
        if(maybeCourse.isEmpty()){
            throw new Exception("No Course found");
        }
        maybeCourse.get().setTitle(eventRequest.getTitle());
        maybeCourse.get().setDescription(eventRequest.getDescription());
        maybeCourse.get().setPicture(eventRequest.getPicture());
        maybeCourse.get().setType(eventRequest.getType());
        maybeCourse.get().setAttendees(eventRequest.getAttendees());
        maybeCourse.get().setPlace(eventRequest.getPlace());
        eventRepository.save(maybeCourse.get());
    }

    public void updateEventAttendee( Long id, List<Long> Attendees) throws Exception {
        Optional<Event> maybeCourse = eventRepository.findById(id);
        if(maybeCourse.isEmpty()){
            throw new Exception("No Course found");
        }
        maybeCourse.get().setAttendees(Attendees);
        eventRepository.save(maybeCourse.get());

    }

    public void createNewEvent(EventRequest eventRequest){
        Event event = new Event(eventRequest.getType(), eventRequest.getDate(), eventRequest.getPlace(), eventRequest.getTitle(), eventRequest.getDescription(), eventRequest.getCreator(), eventRequest.getAttendees(), eventRequest.getPicture());
        eventRepository.save(event);
    }
}
