package com.ironhack.eventservice.services.Impl;

import com.ironhack.eventservice.controller.dto.EventResponse;
import com.ironhack.eventservice.models.Event;
import com.ironhack.eventservice.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            new EventResponse(event.getType(), event.getDate(),event.getTitle(),event.getDescription(), event.getPlace(), event.getType());
        }
        return eventResponses;
    }

    public EventResponse getEventById(Long id) throws Exception {
        Optional<Event> maybeEvent = eventRepository.findById(id);
        if (maybeEvent.isEmpty()) {
            throw new Exception("No Event found");
        }
        return new EventResponse(maybeEvent.get().getType(), maybeEvent.get().getDate(), maybeEvent.get().getTitle(), maybeEvent.get().getDescription(), maybeEvent.get().getPlace(), maybeEvent.get().getType());
    }
}
