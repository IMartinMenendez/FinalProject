package com.ironhack.edge.service.Impl;

import com.ironhack.common.dto.auth.LoginRequest;
import com.ironhack.common.dto.auth.LoginResponse;
import com.ironhack.edge.clients.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthSessionServiceImpl {

    @Autowired
    private UserClient userClient;

    public LoginResponse login(LoginRequest loginRequest) throws Exception{
        return userClient.login(loginRequest);
    }

    public void logout(String token) {
        userClient.logout(token);
    }
}
