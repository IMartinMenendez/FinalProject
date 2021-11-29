package com.ironhack.edge.clients;

import com.ironhack.common.dto.auth.LoginRequest;
import com.ironhack.common.dto.auth.LoginResponse;
import com.ironhack.common.dto.user.UserRequest;
import com.ironhack.common.dto.user.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient("user-service")
public interface UserClient {

    @GetMapping("/Users")
    List<UserResponse> getAllUsers();

    @GetMapping("/Users/{id}")
    UserResponse getUserById(@PathVariable Long id) throws Exception;

    @GetMapping("/User")
    UserResponse getUserByEmail(@RequestParam String email, @RequestParam String password) throws Exception;

    @PostMapping("/Users")
    Long createNewUser(@RequestBody UserRequest userRequest);

    @PostMapping("/login")
    LoginResponse login(@RequestBody LoginRequest loginRequest) throws Exception;

    @GetMapping("/token")
    Long getUserIdByToken(@RequestHeader("X-Auth-Token") String token) throws Exception;

    @DeleteMapping("/logout")
    void logout(@RequestHeader("X-Auth-Token") String token);
}
