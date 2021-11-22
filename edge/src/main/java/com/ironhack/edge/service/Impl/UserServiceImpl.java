package com.ironhack.edge.service.Impl;

import com.ironhack.common.dto.user.UserRequest;
import com.ironhack.common.dto.user.UserResponse;
import com.ironhack.edge.clients.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {

    @Autowired
    UserClient userClient;

    public List<UserResponse> getAllUsers(){
        return userClient.getAllUsers();
    }

    public UserResponse getUserById(Long id) throws Exception {
        return userClient.getUserById(id);
    }

    public void createUser(UserRequest user){
        userClient.createNewUser(user);
    }
}
