package com.ironhack.userservice.controller;


import com.ironhack.common.dto.auth.LoginRequest;
import com.ironhack.common.dto.auth.LoginResponse;
import com.ironhack.userservice.model.User;
import com.ironhack.userservice.services.Impl.AuthServiceImpl;
import com.ironhack.userservice.services.Impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AuthController {

    @Autowired
    private AuthServiceImpl authService;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@RequestBody LoginRequest loginRequest) throws Exception {
        String token = authService.login(loginRequest.getEmail(), loginRequest.getPassword());
        Optional<User> maybeUser = userService.getUserByEmail(loginRequest.getEmail());
        if (maybeUser.isEmpty()) {
            throw new Exception("No User found");
        }
        return new LoginResponse(maybeUser.get().getId(), maybeUser.get().getEventId(), maybeUser.get().getName(), maybeUser.get().getEmail(), maybeUser.get().getRole(), maybeUser.get().getIsAdmin(), token);
    }

    @DeleteMapping("/logout")
    @ResponseStatus(HttpStatus.OK)
    public void logout(@RequestHeader("X-Auth-Token") String token) {
        authService.logout(token);
    }

    @GetMapping("/token")
    @ResponseStatus(HttpStatus.OK)
    public Long getUserIdByToken(@RequestHeader("X-Auth-Token") String token) throws Exception {
        return authService.getUserIdByToken(token);
    }
}
