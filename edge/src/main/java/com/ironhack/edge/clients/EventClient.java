package com.ironhack.edge.clients;

import com.ironhack.common.dto.event.EventRequest;
import com.ironhack.common.dto.event.EventResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@FeignClient("event-service")
public interface EventClient {

    @GetMapping("/Events")
    List<EventResponse> getAllEvents();

    @GetMapping("/Events/{id}")
    EventResponse getEventById(@PathVariable Long id) throws Exception;

    @GetMapping("/myevents/{creator}")
    List<EventResponse> getEventsByCreator(@PathVariable Long creator);

    @GetMapping("/Event/Attendees/{attendeeId}")
    @ResponseStatus(HttpStatus.OK)
    List<EventResponse> getEventByAttendee(@PathVariable Long attendeeId);

    @GetMapping("/Event/{userId}")
    List<EventResponse> getEventByUserId(@PathVariable Long userId) throws Exception;

    @GetMapping("/ComingSoon/{date}")
    @ResponseStatus(HttpStatus.OK)
    List<EventResponse> getEventsComingSoon(@PathVariable String date);

    @GetMapping("/EventFilter")
    @ResponseStatus(HttpStatus.OK)
    List<EventResponse> getEventByTypeAndPlace(@RequestParam String type, @RequestParam String place);

    @GetMapping("/Event/date/{date}/{creator}")
    @ResponseStatus(HttpStatus.OK)
    List<EventResponse> getEventByDate(@PathVariable String date, @PathVariable Long creator);

    @DeleteMapping("/Event/{id}")
    void deleteEventId(@PathVariable Long id) throws Exception;

    @PutMapping("/Event/{id}")
    void updateEvent(@PathVariable Long id,  @RequestBody EventRequest eventRequest) throws Exception;

    @PutMapping("/Event/Attendees-add/{id}")
    @ResponseStatus(HttpStatus.OK)
    void addNewAttendee(@PathVariable Long id,  @RequestBody Long attendeesId) throws Exception;

    @PutMapping("/Event/Attendees-remove/{id}")
    void removeEventAttendee(@PathVariable Long id,  @RequestBody Long attendeesId) throws Exception;

    @PostMapping("/Events")
    void createNewEvent(@RequestBody EventRequest eventRequest);
}
