package com.ironhack.edge.service.Impl;

import com.ironhack.common.dto.event.EventRequest;
import com.ironhack.common.dto.event.EventResponse;
import com.ironhack.edge.clients.EventClient;
import com.ironhack.edge.clients.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl {

    @Autowired
    EventClient eventClient;

    @Autowired
    UserClient authorSessionClient;

    public List<EventResponse> getAllEvents(){
        return eventClient.getAllEvents();
    }

    public EventResponse getEventById(Long id) throws Exception{
        return eventClient.getEventById(id);
    }

    public List<EventResponse> getEventByUserId(Long userId, String token) throws Exception{
        Long user = authorSessionClient.getUserIdByToken(token);
        if( user.equals(userId)){
            return eventClient.getEventByUserId(userId);
        }else{
            throw new Exception("User not authenticated");
        }
    }

    public List<EventResponse> getEventByAttendee(Long attendeeId, String token) throws Exception {
        Long user = authorSessionClient.getUserIdByToken(token);
        if(  user.equals(attendeeId)){
            return eventClient.getEventByAttendee(attendeeId);
        }else{
            throw new Exception("User not authenticated");
        }
    }

    public List<EventResponse> getEventsByCreator(Long creator, String token) throws Exception {
       Long user = authorSessionClient.getUserIdByToken(token);
        if( user.equals(creator)){
            return eventClient.getEventsByCreator(creator);
        }else{
            throw new Exception("User not authenticated");
        }

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

    public void removeEventAttendee( Long id, Long attendeesId) throws Exception{
        eventClient.removeEventAttendee(id, attendeesId);
    }

    public void createNewEvent( EventRequest eventRequest){
        eventClient.createNewEvent(eventRequest);
    }


}
