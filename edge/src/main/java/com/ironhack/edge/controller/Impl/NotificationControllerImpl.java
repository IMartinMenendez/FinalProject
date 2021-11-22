package com.ironhack.edge.controller.Impl;

import com.ironhack.common.dto.notifications.NotificationResponse;
import com.ironhack.edge.clients.NotificationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class NotificationControllerImpl {

    @Autowired
    NotificationClient notificationClient;

    public List<NotificationResponse> getAllNotifications(){
        return notificationClient.getAllNotifications();
    }

    public NotificationResponse getNotificationById(@PathVariable Long id) throws Exception{
        return notificationClient.getNotificationById(id);
    }

    public List<NotificationResponse> getNotificationByUserId(@PathVariable Long userId){
        return notificationClient.getNotificationByUserId(userId);
    }
}
