package com.ironhack.edge.controller.Impl;

import com.ironhack.common.dto.user.UserRequest;
import com.ironhack.common.dto.user.UserResponse;
import com.ironhack.edge.clients.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserControllerImpl {

    @Autowired
    UserClient userService;

    @GetMapping("/Users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/Users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUserById(@PathVariable Long id) throws Exception {
        return userService.getUserById(id);
    }

    @PostMapping("/Users")
    @ResponseStatus(HttpStatus.OK)
    public void createNewUser(@RequestBody UserRequest userRequest){
        userService.createNewUser(userRequest);
    }
}
