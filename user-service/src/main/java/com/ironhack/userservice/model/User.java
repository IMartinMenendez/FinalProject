package com.ironhack.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    @ElementCollection
    private List<Long> eventId;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String role;
    @Getter
    @Setter
    private Boolean isAdmin;
    @Getter
    @Setter
    private String password;
}