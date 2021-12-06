package com.ironhack.common.dto.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class EventKafka {
    @Getter
    @Setter
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
    private List<Long> attendees;
    @Getter
    @Setter
    private String picture;
    @Getter
    @Setter
    private boolean isDeleted;
}
