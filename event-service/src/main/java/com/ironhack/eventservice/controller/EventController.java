package com.ironhack.eventservice.controller;

import com.ironhack.eventservice.controller.dto.EventResponse;
import com.ironhack.eventservice.services.Impl.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

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
}
