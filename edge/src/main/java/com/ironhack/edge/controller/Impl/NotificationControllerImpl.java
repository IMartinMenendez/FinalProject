package com.ironhack.edge.controller.Impl;

import com.ironhack.common.dto.notifications.NotificationResponse;
import com.ironhack.edge.service.Impl.NotificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationControllerImpl {

    @Autowired
    NotificationServiceImpl notificationService;

    @GetMapping("/Notifications")
    @CrossOrigin(value = "http://localhost:4200")
    @ResponseStatus(HttpStatus.OK)
    public List<NotificationResponse> getAllNotifications(){
        return notificationService.getAllNotifications();
    }

    @GetMapping("/Notification/{id}")
    @CrossOrigin(value = "http://localhost:4200")
    @ResponseStatus(HttpStatus.OK)
    public NotificationResponse getNotificationById(@PathVariable Long id) throws Exception{
        return notificationService.getNotificationById(id);
    }

    @GetMapping("/Notifications/{userId}")
    @CrossOrigin(value = "http://localhost:4200")
    @ResponseStatus(HttpStatus.OK)
    public List<NotificationResponse> getNotificationByUserId(@PathVariable Long userId){
        return notificationService.getNotificationByUserId(userId);
    }

    @PutMapping("/Notifications/{id}")
    @CrossOrigin(value = "http://localhost:4200")
    @ResponseStatus(HttpStatus.OK)
    public void updateToReadNotification(@PathVariable Long id){
        notificationService.updateToReadNotification(id);
    }
}
