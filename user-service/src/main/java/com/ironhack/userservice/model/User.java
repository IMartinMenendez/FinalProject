package com.ironhack.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Getter
    @Setter
    @GeneratedValue
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
    @Getter
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected Set<Role> roles;

    public User(List<Long> eventId, String name, String email, String role, Boolean isAdmin, String password) {
        this.eventId = eventId;
        this.name = name;
        this.email = email;
        this.role = role;
        this.isAdmin = isAdmin;
        this.password = password;
    }


}
