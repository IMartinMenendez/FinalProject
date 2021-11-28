package com.ironhack.edge.controller.Impl;

import com.ironhack.common.dto.user.UserRequest;
import com.ironhack.common.dto.user.UserResponse;
import com.ironhack.edge.clients.UserClient;
import com.ironhack.edge.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserControllerImpl {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/Users")
    @CrossOrigin(value = "http://localhost:4200")
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/Users/{id}")
    @CrossOrigin(value = "http://localhost:4200")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUserById(@PathVariable Long id) throws Exception {
        return userService.getUserById(id);
    }

    @PostMapping("/Users")
    @CrossOrigin(value = "http://localhost:4200")
    @ResponseStatus(HttpStatus.OK)
    public Long createNewUser(@RequestBody UserRequest userRequest){
        return userService.createUser(userRequest);
    }
}
