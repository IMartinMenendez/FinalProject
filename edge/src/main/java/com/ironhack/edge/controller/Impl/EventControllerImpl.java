package com.ironhack.edge.controller.Impl;

import com.ironhack.common.dto.event.EventRequest;
import com.ironhack.common.dto.event.EventResponse;
import com.ironhack.edge.service.Impl.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class EventControllerImpl {

    @Autowired
    EventServiceImpl eventService;

    @GetMapping("/Events")
    @CrossOrigin(value = "http://localhost:4200")
    @ResponseStatus(HttpStatus.OK)
    public List<EventResponse> getAllEvents(){
        return eventService.getAllEvents();
    }

    @GetMapping("/Events/{id}")
    @CrossOrigin(value = "http://localhost:4200")
    @ResponseStatus(HttpStatus.OK)
    public EventResponse getEventById(@PathVariable Long id) throws Exception{
        return eventService.getEventById(id);
    }

    @GetMapping("/myevents/{creator}")
    @CrossOrigin(value = "http://localhost:4200")
    @ResponseStatus(HttpStatus.OK)
    List<EventResponse> getEventsByCreator(@PathVariable Long creator,  @RequestHeader("X-Auth-Token") String token) throws Exception {
        return eventService.getEventsByCreator(creator, token);
    }

    @GetMapping("/Event/Attendees/{attendeeId}")
    @CrossOrigin(value = "http://localhost:4200")
    @ResponseStatus(HttpStatus.OK)
    public List<EventResponse> getEventByAttendee(@PathVariable Long attendeeId,  @RequestHeader("X-Auth-Token") String token) throws Exception {
        List<EventResponse> events = eventService.getEventByAttendee(attendeeId, token);
        return events;
    }

    @GetMapping("/Event/{userId}")
    @CrossOrigin(value = "http://localhost:4200")
    @ResponseStatus(HttpStatus.OK)
    public List<EventResponse> getEventByUserId(@PathVariable Long userId ,@RequestHeader("X-Auth-Token") String token) throws Exception{
        return eventService.getEventByUserId(userId, token);
    }

    @GetMapping("/EventFilter")
    @CrossOrigin(value = "http://localhost:4200")
    @ResponseStatus(HttpStatus.OK)
    public List<EventResponse> getEventByTypeAndPlace(@RequestParam String type, @RequestParam String place){
        return eventService.getEventByTypeAndPlace(type, place);
    }

    @GetMapping("/ComingSoon/{date}")
    @CrossOrigin(value = "http://localhost:4200")
    @ResponseStatus(HttpStatus.OK)
    public List<EventResponse> getEventsComingSoon(@PathVariable String date) {
        return eventService.getEventsComingSoon(date);
    }

    @DeleteMapping("/Event/{id}")
    @CrossOrigin(value = "http://localhost:4200")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEventId(@PathVariable Long id) throws Exception{
        eventService.deleteEventId(id);
    }

    @PutMapping("/Event/{id}")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(value = "http://localhost:4200")
    public void updateEvent(@PathVariable Long id,  @RequestBody EventRequest eventRequest) throws Exception{
        eventService.updateEvent(id, eventRequest);
    }

    @PutMapping("/Event/Attendees/{id}")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(value = "http://localhost:4200")
    public void addNewAttendee(@PathVariable Long id,  @RequestBody Long attendeesId) throws Exception{
        eventService.addNewAttendee(id, attendeesId);
    }

    @PutMapping("/Event/Attendees-remove/{id}")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(value = "http://localhost:4200")
    public void removeEventAttendee(@PathVariable Long id,  @RequestBody Long attendeesId) throws Exception {
        eventService.removeEventAttendee(id, attendeesId);
    }

    @PostMapping("/Events")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(value = "http://localhost:4200")
    public void createNewEvent(@RequestBody EventRequest eventRequest){
        eventService.createNewEvent(eventRequest);
    }
}
