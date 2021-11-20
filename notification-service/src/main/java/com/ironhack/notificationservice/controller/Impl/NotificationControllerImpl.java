package com.ironhack.notificationservice.controller.Impl;

import com.ironhack.notificationservice.controller.dto.NotificationResponse;
import com.ironhack.notificationservice.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
public class NotificationControllerImpl {

    @Autowired
    NotificationService notificationService;

    @GetMapping("/Notifications")
    @ResponseStatus(HttpStatus.OK)
    public List<NotificationResponse> getAllNotifications(){
        return notificationService.getAllNotifications();
    }

    @GetMapping("/Notifications/{id}")
    @ResponseStatus(HttpStatus.OK)
    public NotificationResponse getCourseById(@PathVariable Long id) throws Exception {
        return notificationService.getNotificationById(id);
    }

    @GetMapping("/Notifications/{UserId}")
    @ResponseStatus(HttpStatus.OK)
    public List<NotificationResponse> getNotificationByUserId(@PathVariable Long UserId){
        return notificationService.getNotificationByUserId(UserId);
    }


}
