package com.ironhack.edge.controller.Impl;

import com.ironhack.common.dto.notifications.NotificationResponse;
import com.ironhack.edge.clients.NotificationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationControllerImpl {

    @Autowired
    NotificationClient notificationClient;

    @GetMapping("/Notifications")
    @CrossOrigin(value = "http://localhost:4200")
    @ResponseStatus(HttpStatus.OK)
    public List<NotificationResponse> getAllNotifications(){
        return notificationClient.getAllNotifications();
    }

    @GetMapping("/Notifications/{id}")
    @CrossOrigin(value = "http://localhost:4200")
    @ResponseStatus(HttpStatus.OK)
    public NotificationResponse getNotificationById(@PathVariable Long id) throws Exception{
        return notificationClient.getNotificationById(id);
    }

    @GetMapping("/Notifications/{userId}")
    @CrossOrigin(value = "http://localhost:4200")
    @ResponseStatus(HttpStatus.OK)
    public List<NotificationResponse> getNotificationByUserId(@PathVariable Long userId){
        return notificationClient.getNotificationByUserId(userId);
    }
}
