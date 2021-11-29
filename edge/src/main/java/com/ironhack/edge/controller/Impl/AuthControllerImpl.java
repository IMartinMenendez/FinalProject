package com.ironhack.edge.controller.Impl;


import com.ironhack.common.dto.auth.LoginRequest;
import com.ironhack.common.dto.auth.LoginResponse;
import com.ironhack.edge.service.Impl.AuthSessionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class AuthControllerImpl {

    @Autowired
    private AuthSessionServiceImpl authSessionService;

    @PostMapping("/login")
    @CrossOrigin(value = "http://localhost:4200")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@RequestBody LoginRequest loginRequest) throws Exception {
        return authSessionService.login(loginRequest);
    }

    @DeleteMapping("/logout")
    @CrossOrigin(value = "http://localhost:4200")
    @ResponseStatus(HttpStatus.OK)
    public void logout(@RequestHeader("X-Auth-Token") String token) {
        authSessionService.logout(token);
    }

//    @GetMapping("/token")
//    @CrossOrigin(value = "http://localhost:4200")
//    public Long getUserIdByToken(@RequestParam String token) throws Exception {
//        return authSessionService.getUserIdByToken(token);
//    }

}
