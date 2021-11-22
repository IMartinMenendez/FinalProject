package com.ironhack.notificationservice.controller.Impl;
import com.ironhack.common.dto.notifications.NotificationResponse;
import com.ironhack.notificationservice.models.Notification;
import com.ironhack.notificationservice.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class NotificationControllerImpl {

    @Autowired
    NotificationService notificationService;

    @GetMapping("/Notifications")
    @ResponseStatus(HttpStatus.OK)
    public List<NotificationResponse> getAllNotifications(){
        List<Notification> notifications = notificationService.getAllNotifications();
        List<NotificationResponse> notificationResponses = new ArrayList<>();
        for (Notification notification : notifications) {
            new NotificationResponse(notification.getUserId(), notification.getMessage(), notification.getIsRead());
        }
        return notificationResponses;
    }

    @GetMapping("/Notifications/{id}")
    @ResponseStatus(HttpStatus.OK)
    public NotificationResponse getNotificationById(@PathVariable Long id) throws Exception {
        Optional<Notification> maybeNotification = notificationService.getNotificationById(id);
        if(maybeNotification.isEmpty()){
            throw new Exception("No Notification found");
        }
        return new NotificationResponse(maybeNotification.get().getUserId(), maybeNotification.get().getMessage(), maybeNotification.get().getIsRead());

    }

    @GetMapping("/Notifications/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<NotificationResponse> getNotificationByUserId(@PathVariable Long userId){
        List<Notification> notifications = notificationService.getNotificationByUserId(userId);
                List<NotificationResponse> notificationResponses = new ArrayList<>();
        for (Notification notification : notifications) {
            new NotificationResponse(notification.getUserId(), notification.getMessage(), notification.getIsRead());
        }
        return notificationResponses;
    }


}
