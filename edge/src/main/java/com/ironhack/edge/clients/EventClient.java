package com.ironhack.edge.clients;

import com.ironhack.common.dto.event.EventRequest;
import com.ironhack.common.dto.event.EventResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("event-service")
public interface EventClient {

    @GetMapping("/Events")
    List<EventResponse> getAllEvents();

    @GetMapping("/Events/{id}")
    EventResponse getEventById(@PathVariable Long id) throws Exception;

    @GetMapping("/Event/{userId}")
    List<EventResponse> getEventByUserId(@PathVariable Long userId) throws Exception;

    @DeleteMapping("/Event/{id}")
    void deleteEventId(@PathVariable Long id) throws Exception;

    @PutMapping("/Event/{id}")
    void updateEvent(@PathVariable Long id,  @RequestBody EventRequest eventRequest) throws Exception;

    @PutMapping("/Event/Attendees/{id}")
    void addNewAttendee(@PathVariable Long id,  @RequestBody Long attendeesId) throws Exception;

    @PutMapping("/Event/Attendees-remove/{id}")
    void removeEventAttendee(@PathVariable Long id,  @RequestBody Long attendeesId) throws Exception;

    @PostMapping("/Events")
    void createNewEvent(@RequestBody EventRequest eventRequest);
}
