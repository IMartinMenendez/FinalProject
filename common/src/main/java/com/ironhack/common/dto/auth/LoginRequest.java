package com.ironhack.common.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String password;

}
