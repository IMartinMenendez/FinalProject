package com.ironhack.eventservice.controller;

import com.ironhack.common.dto.event.EventKafka;
import com.ironhack.common.dto.event.EventRequest;
import com.ironhack.common.dto.event.EventResponse;
import com.ironhack.eventservice.KafkaProducerConfig;
import com.ironhack.eventservice.models.Event;
import com.ironhack.eventservice.services.Impl.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class EventController {

    @Autowired
    EventService eventService;

    @Autowired
    private KafkaTemplate<String, EventKafka> kafkaTemplate;

    @GetMapping("/Events")
    @ResponseStatus(HttpStatus.OK)
    public List<EventResponse> getAllEvents(){
        List<Event> events = eventService.getAllEvents();
        List<EventResponse> eventResponses = new ArrayList<>();
        for (Event event : events) {
            eventResponses.add(new EventResponse(event.getId(), event.getType(), event.getDate(), event.getPlace(), event.getTitle(), event.getDescription(), event.getCreator(), event.getAttendees(),  event.getPicture()));
        }
        return eventResponses;
    }

    @GetMapping("/Events/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EventResponse getEventById(@PathVariable Long id) throws Exception {
        Optional<Event> maybeEvent = eventService.getEventById(id);
        if (maybeEvent.isEmpty()) {
            throw new Exception("No Event found");
        }
        return new EventResponse(maybeEvent.get().getId(), maybeEvent.get().getType(), maybeEvent.get().getDate(), maybeEvent.get().getPlace(), maybeEvent.get().getTitle(), maybeEvent.get().getDescription(), maybeEvent.get().getCreator(),maybeEvent.get().getAttendees(), maybeEvent.get().getPicture());

    }

    @GetMapping("/Event/date/{date}/{creator}")
    @ResponseStatus(HttpStatus.OK)
    public List<EventResponse> getEventByDate(@PathVariable String date, @PathVariable Long creator){
        List<Event> events = eventService.getEventByDate(date, creator);
        List<EventResponse> eventResponses = new ArrayList<>();
        for (Event event : events) {
            eventResponses.add(new EventResponse(event.getId(), event.getType(), event.getDate(), event.getPlace(), event.getTitle(), event.getDescription(), event.getCreator(), event.getAttendees(),  event.getPicture()));
        }
        return eventResponses;
    }

    @GetMapping("/Event/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<EventResponse> getEventByUserId(@PathVariable Long userId, @RequestHeader("X-Auth-Token") String token) throws Exception {
        List<Event> events = eventService.getEventByUserId(userId);
        List<EventResponse> eventResponses = new ArrayList<>();
        for (Event event : events) {
            eventResponses.add(new EventResponse(event.getId(), event.getType(), event.getDate(), event.getPlace(), event.getTitle(), event.getDescription(), event.getCreator(), event.getAttendees(),  event.getPicture()));
        }
        return eventResponses;
    }

    @GetMapping("/Event/Attendees/{attendeeId}")
    @ResponseStatus(HttpStatus.OK)
    public List<EventResponse> getEventByAttendee(@PathVariable Long attendeeId)  {
        List<Event> events = eventService.getEventByAttendee(attendeeId);
        List<EventResponse> eventResponses = new ArrayList<>();
        for (Event event : events) {
            eventResponses.add(new EventResponse(event.getId(), event.getType(), event.getDate(), event.getPlace(), event.getTitle(), event.getDescription(), event.getCreator(), event.getAttendees(),  event.getPicture()));
        }
        return eventResponses;
    }

    @GetMapping("/myevents/{creator}")
    @ResponseStatus(HttpStatus.OK)
    public List<EventResponse> getEventsByCreator(@PathVariable Long creator) {
        List<Event> events = eventService.getEventsByCreator(creator);
        List<EventResponse> eventResponses = new ArrayList<>();
        for (Event event : events) {
            eventResponses.add(new EventResponse(event.getId(), event.getType(), event.getDate(), event.getPlace(), event.getTitle(), event.getDescription(), event.getCreator(), event.getAttendees(),  event.getPicture()));
        }
        return eventResponses;
    }

    @GetMapping("/ComingSoon/{date}")
    @ResponseStatus(HttpStatus.OK)
    public List<EventResponse> getEventsComingSoon(@PathVariable String date) {
        List<Event> events = eventService.getEventsComingSoon(date);
        List<EventResponse> eventResponses = new ArrayList<>();
        for (Event event : events) {
            eventResponses.add(new EventResponse(event.getId(), event.getType(), event.getDate(), event.getPlace(), event.getTitle(), event.getDescription(), event.getCreator(), event.getAttendees(),  event.getPicture()));
        }
        return eventResponses;
    }

    @GetMapping("/EventFilter")
    @ResponseStatus(HttpStatus.OK)
    public List<EventResponse> getEventByTypeAndPlace(@RequestParam String type, @RequestParam String place) {
        List<Event> events = eventService.getEventByTypeAndPlace(type, place);
        List<EventResponse> eventResponses = new ArrayList<>();
        for (Event event : events) {
            eventResponses.add(new EventResponse(event.getId(), event.getType(), event.getDate(), event.getPlace(), event.getTitle(), event.getDescription(), event.getCreator(), event.getAttendees(),  event.getPicture()));
        }
        return eventResponses;
    }

    @DeleteMapping("/Event/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEventId(@PathVariable Long id) throws Exception {
        Optional<Event> event = eventService.getEventById(id);
        if(event.isPresent()){
            kafkaTemplate.send("events", new EventKafka(event.get().getId(), event.get().getType(), event.get().getDate(), event.get().getPlace(), event.get().getTitle(), event.get().getDescription(), event.get().getCreator(), event.get().getAttendees(),  event.get().getPicture(), true));
        }
        eventService.deleteEvent(id);
    }

    @PutMapping("/Event/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateEvent(@PathVariable Long id,  @RequestBody EventRequest eventRequest) throws Exception {
        Event event = new Event(eventRequest.getType(), eventRequest.getDate(), eventRequest.getPlace(), eventRequest.getTitle(), eventRequest.getDescription(), eventRequest.getCreator(), eventRequest.getAttendees(),  eventRequest.getPicture());
        kafkaTemplate.send("events", new EventKafka(event.getId(), event.getType(), event.getDate(), event.getPlace(), event.getTitle(), event.getDescription(), event.getCreator(), event.getAttendees(),  event.getPicture(), false));
        eventService.updateEvent(id, event);
    }

    @PutMapping("/Event/Attendees-add/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void addNewAttendee(@PathVariable Long id,  @RequestBody Long attendeesId) throws Exception {
        eventService.updateEventAttendee(id, attendeesId);
    }

    @PutMapping("/Event/Attendees-remove/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeEventAttendee(@PathVariable Long id,  @RequestBody Long attendeesId) throws Exception {
        eventService.removeEventAttendee(id, attendeesId);
    }

    @PostMapping("/Events")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewEvent(@RequestBody EventRequest eventRequest){
        Event event = new Event(eventRequest.getType(), eventRequest.getDate(), eventRequest.getPlace(), eventRequest.getTitle(), eventRequest.getDescription(), eventRequest.getCreator(), eventRequest.getAttendees(),  eventRequest.getPicture());
        eventService.createNewEvent(event);
    }

}
