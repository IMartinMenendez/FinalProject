package com.ironhack.eventservice.services.Impl;

import com.ironhack.eventservice.models.Event;
import com.ironhack.eventservice.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Long id) throws Exception {
        return eventRepository.findById(id);
    }

    public List<Event> getEventByUserId(Long id){
        return eventRepository.getEventByUser(id);
    }

    public List<Event> getEventByAttendee(Long attendeeId){
        return eventRepository.getEventByAttendee(attendeeId);
    }

    public void deleteEvent(Long id) throws Exception {
        Optional<Event> maybeEvent = eventRepository.findById(id);
        if(maybeEvent.isEmpty()){
            throw new Exception("No Event found");
        }
        eventRepository.delete(maybeEvent.get());
    }

    public List<Event> getEventByDate(String date, Long creator){
        return eventRepository.getEventByDate(date, creator);
    }

    public void updateEvent(Long id, Event eventRequest) throws Exception {
        Optional<Event> maybeCourse = eventRepository.findById(id);
        if(maybeCourse.isEmpty()){
            throw new Exception("No Event found");
        }
        maybeCourse.get().setTitle(eventRequest.getTitle());
        maybeCourse.get().setDescription(eventRequest.getDescription());
        maybeCourse.get().setPicture(eventRequest.getPicture());
        maybeCourse.get().setType(eventRequest.getType());
        maybeCourse.get().setAttendees(eventRequest.getAttendees());
        maybeCourse.get().setPlace(eventRequest.getPlace());
        eventRepository.save(maybeCourse.get());
    }

    public void updateEventAttendee(Long id, Long attendeesId) throws Exception {
        Optional<Event> maybeCourse = eventRepository.findById(id);
        if(maybeCourse.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No Event found");
        }
        List<Long> eventId = maybeCourse.get().getAttendees();
        for(int i=0; i < eventId.size(); i++){
            if(eventId.get(i).equals(id)){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You are already enrolled in this course");
            }
        }
        eventId.add(attendeesId);
        eventRepository.save(maybeCourse.get());
    }

    public void removeEventAttendee(Long id, Long attendeesId) throws Exception {
        Optional<Event> maybeCourse = eventRepository.findById(id);
        if(maybeCourse.isEmpty()){
            throw new Exception("No Event found");
        }
        maybeCourse.get().getAttendees().remove(attendeesId);
        eventRepository.save(maybeCourse.get());
    }

    public List<Event> getEventsComingSoon(String date){
        return eventRepository.getEventsComingSoon(date);
    }

    public List<Event> getEventByTypeAndPlace(String type, String place){
        if(!type.equals("undefined") && !place.equals("undefined")){
            return eventRepository.getEventByTypeAndPlace(type, place);
        } else if (!type.equals("undefined")){
            return eventRepository.getEventByType(type);
        } else{
            return eventRepository.getEventByPlace(place);
        }
    }

    public void createNewEvent(Event eventRequest){
        Event event = new Event(eventRequest.getType(), eventRequest.getDate(), eventRequest.getPlace(), eventRequest.getTitle(), eventRequest.getDescription(), eventRequest.getCreator(), eventRequest.getAttendees(), eventRequest.getPicture());
        eventRepository.save(event);
    }

    public List<Event> getEventsByCreator(Long creator) {
        return eventRepository.getEventByCreator(creator);
    }
}
