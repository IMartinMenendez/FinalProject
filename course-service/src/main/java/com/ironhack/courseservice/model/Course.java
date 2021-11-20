package com.ironhack.courseservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @Getter
    @Setter
    @GeneratedValue
    private Long id;
    @Getter
    @Setter
    private Long creatorId;
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private String link;
    @Getter
    @Setter
    private String picture;
}
