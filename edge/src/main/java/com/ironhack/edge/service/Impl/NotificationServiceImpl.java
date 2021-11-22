package com.ironhack.edge.service.Impl;

import com.ironhack.common.dto.notifications.NotificationResponse;
import com.ironhack.edge.clients.NotificationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class NotificationServiceImpl {

    @Autowired
    NotificationClient notificationClient;

    @GetMapping("/Notifications")
    List<NotificationResponse> getAllNotifications(){
        return notificationClient.getAllNotifications();
    }

    @GetMapping("/Notifications/{id}")
    NotificationResponse getNotificationById(@PathVariable Long id) throws Exception{
        return notificationClient.getNotificationById(id);
    }

    @GetMapping("/Notifications/{userId}")
    List<NotificationResponse> getNotificationByUserId(@PathVariable Long userId){
        return notificationClient.getNotificationByUserId(userId);
    }
}
