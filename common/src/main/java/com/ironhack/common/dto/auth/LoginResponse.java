package com.ironhack.common.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ElementCollection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
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
    private String token;
}
