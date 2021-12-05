package com.ironhack.eventservice.repository;

import com.ironhack.eventservice.enums.Type;
import com.ironhack.eventservice.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT e FROM Event e WHERE e.creator = :user")
    List<Event> getEventByUser(@Param("user") Long user);

    @Query("SELECT e FROM Event e WHERE e.type = :type")
    List<Event> getEventsByType(@Param("type") Type type);

    @Query("SELECT e FROM Event e WHERE e.place = :place AND e.date = :date")
    List<Event> getEventsByDateAndPlace(@Param("place") String place, @Param("date") Date date);

    @Query("select e FROM Event e WHERE e.creator = :creator")
    List<Event> getEventByCreator(@Param("creator") Long creator);

    @Query(value="SELECT * FROM EVENT E left JOIN event_attendees D ON d.event_id = e.id where d.attendees = :attendeeId", nativeQuery = true)
    List<Event> getEventByAttendee(Long attendeeId);
}
