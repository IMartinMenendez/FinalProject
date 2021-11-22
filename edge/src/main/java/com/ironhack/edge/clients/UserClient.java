package com.ironhack.edge.clients;

import com.ironhack.common.dto.user.UserRequest;
import com.ironhack.common.dto.user.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("user-service")
public interface UserClient {

    @GetMapping("/Users")
    List<UserResponse> getAllUsers();

    @GetMapping("/Users/{id}")
    UserResponse getUserById(@PathVariable Long id) throws Exception;

    @PostMapping("/Users")
    void createNewUser(@RequestBody UserRequest userRequest);
}
