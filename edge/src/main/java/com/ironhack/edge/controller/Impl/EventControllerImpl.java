package com.ironhack.edge.controller.Impl;

import com.ironhack.common.dto.event.EventRequest;
import com.ironhack.common.dto.event.EventResponse;
import com.ironhack.edge.service.Impl.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EventControllerImpl {

    @Autowired
    EventServiceImpl eventService;

    @GetMapping("/Events")
    @ResponseStatus(HttpStatus.OK)
    public List<EventResponse> getAllEvents(){
        return eventService.getAllEvents();
    }

    @GetMapping("/Events/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EventResponse getEventById(@PathVariable Long id) throws Exception{
        return eventService.getEventById(id);
    }

    @GetMapping("/Event/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<EventResponse> getEventByUserId(@PathVariable Long userId) throws Exception{
        return eventService.getEventByUserId(userId);
    }

    @DeleteMapping("/Event/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEventId(@PathVariable Long id) throws Exception{
        eventService.deleteEventId(id);
    }

    @PutMapping("/Event/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateEvent(@PathVariable Long id,  @RequestBody EventRequest eventRequest) throws Exception{
        eventService.updateEvent(id, eventRequest);
    }

    @PutMapping("/Event/Attendees/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void addNewAttendee(@PathVariable Long id,  @RequestBody Long attendeesId) throws Exception{
        eventService.addNewAttendee(id, attendeesId);
    }

    @PutMapping("/Event/Attendees-remove/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeEventAttendee(@PathVariable Long id,  @RequestBody Long attendeesId) throws Exception {
        eventService.removeEventAttendee(id, attendeesId);
    }

    @PostMapping("/Events")
    @ResponseStatus(HttpStatus.OK)
    public void createNewEvent(@RequestBody EventRequest eventRequest){
        eventService.createNewEvent(eventRequest);
    }
}
