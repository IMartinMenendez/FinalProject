package com.ironhack.eventservice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class EventResponse {
    @Getter
    @Setter
    private String type;
    @Getter
    @Setter
    private Date date;
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private String place;
    @Getter
    @Setter
    private String picture;
}
