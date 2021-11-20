package com.ironhack.eventservice.controller;

import com.ironhack.eventservice.controller.dto.EventRequest;
import com.ironhack.eventservice.controller.dto.EventResponse;
import com.ironhack.eventservice.services.Impl.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping("/Events")
    @ResponseStatus(HttpStatus.OK)
    public List<EventResponse> getAllEvents(){
        return eventService.getAllEvents();
    }

    @GetMapping("/Events/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EventResponse getEventById(@PathVariable Long id) throws Exception {
        return eventService.getEventById(id);
    }

    @GetMapping("/Event/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<EventResponse> getCourseByUserId(@PathVariable Long userId) throws Exception {
        return eventService.getEventByUserId(userId);
    }

    @DeleteMapping("/Event/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCourseId(@PathVariable Long id) throws Exception {
        eventService.deleteEvent(id);
    }

    @PutMapping("/Event/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCourse(@PathVariable Long id,  @RequestBody EventRequest eventRequest) throws Exception {
        eventService.updateEvent(id, eventRequest);
    }

    @PostMapping("/Events")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewCourse(@RequestBody EventRequest eventRequest){
        eventService.createNewEvent(eventRequest);
    }

}
