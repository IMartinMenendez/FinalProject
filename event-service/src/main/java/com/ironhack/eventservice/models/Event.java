package com.ironhack.eventservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    @Getter
    @Setter
    @GeneratedValue
    private Long id;
    @Getter
    @Setter
    private String type;
    @Getter
    @Setter
    private Date date;
    @Getter
    @Setter
    private String place;
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private Long creator;
    @Getter
    @Setter
    @ElementCollection
    private List<Long> attendees;
    @Getter
    @Setter
    private String picture;

    public Event(String type, Date date, String place, String title, String description, Long creator, List<Long> attendees, String picture) {
        this.type = type;
        this.date = date;
        this.place = place;
        this.title = title;
        this.description = description;
        this.creator = creator;
        this.attendees = attendees;
        this.picture = picture;
    }
}
