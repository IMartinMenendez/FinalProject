package com.ironhack.edge.service.Impl;

import com.ironhack.common.dto.event.EventRequest;
import com.ironhack.common.dto.event.EventResponse;
import com.ironhack.edge.clients.EventClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EventServiceImpl {

    @Autowired
    EventClient eventClient;

    public List<EventResponse> getAllEvents(){
        return eventClient.getAllEvents();
    }

    public EventResponse getEventById(Long id) throws Exception{
        return eventClient.getEventById(id);
    }

    public List<EventResponse> getEventByUserId( Long userId) throws Exception{
        return eventClient.getEventByUserId(userId);
    }

    public void deleteEventId(Long id) throws Exception{
        eventClient.deleteEventId(id);
    }

    public void updateEvent(Long id, EventRequest eventRequest) throws Exception{
        eventClient.updateEvent(id, eventRequest);
    }

    public void addNewAttendee(Long id, Long attendeesId) throws Exception{
        eventClient.addNewAttendee(id, attendeesId);
    }

    public void removeEventAttendee(@PathVariable Long id, @RequestBody Long attendeesId) throws Exception{
        eventClient.removeEventAttendee(id, attendeesId);
    }

    public void createNewEvent( EventRequest eventRequest){
        eventClient.createNewEvent(eventRequest);
    }
}
