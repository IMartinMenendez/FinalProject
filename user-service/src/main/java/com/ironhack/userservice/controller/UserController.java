package com.ironhack.userservice.controller;

import com.ironhack.common.dto.user.UserRequest;
import com.ironhack.common.dto.user.UserResponse;
import com.ironhack.userservice.model.User;
import com.ironhack.userservice.services.Impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/Users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getAllUsers(){
        List<User> users = userService.getAllUsers();
        List<UserResponse> usersResponses = new ArrayList<>();
        for (User user : users) {
            new UserResponse(user.getId(), user.getEventId(),  user.getName(), user.getEmail(), user.getRole(), user.getIsAdmin());
        }
        return usersResponses;
    }

    @GetMapping("/Users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUserById(@PathVariable Long id) throws Exception {
        Optional<User> maybeUser = userService.getUserById(id);
        if(maybeUser.isEmpty()){
            throw new Exception("No User found");
        }
        return new UserResponse(maybeUser.get().getId(), maybeUser.get().getEventId(),  maybeUser.get().getName(), maybeUser.get().getEmail(), maybeUser.get().getRole(), maybeUser.get().getIsAdmin());
    }

    @GetMapping("/User")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUserByEmail(@RequestParam String email, @RequestParam String password) throws Exception {
        Optional<User> maybeUser = userService.getUserByEmail(email);
        if(maybeUser.isEmpty()){
            throw new Exception("No User found");
        } else {
            if(Objects.equals(maybeUser.get().getPassword(), password)){
                return new UserResponse(maybeUser.get().getId(), maybeUser.get().getEventId(),  maybeUser.get().getName(), maybeUser.get().getEmail(), maybeUser.get().getRole(), maybeUser.get().getIsAdmin());
            } else {
                throw new Exception("Incorrect Password");
            }
        }
    }

    @PostMapping("/Users")
    @CrossOrigin(value = "http://localhost:4200")
    @ResponseStatus(HttpStatus.OK)
    public Long createNewUser(@RequestBody UserRequest userRequest){
        User user = new User(userRequest.getEventId(), userRequest.getName(), userRequest.getEmail(), userRequest.getRole(), userRequest.getIsAdmin(), userRequest.getPassword());
        return userService.createUser(user);
    }


}
