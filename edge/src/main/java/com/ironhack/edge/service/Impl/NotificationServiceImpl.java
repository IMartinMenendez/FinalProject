package com.ironhack.edge.service.Impl;

import com.ironhack.common.dto.notifications.NotificationResponse;
import com.ironhack.edge.clients.NotificationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class NotificationServiceImpl {

    @Autowired
    NotificationClient notificationClient;

    public List<NotificationResponse> getAllNotifications(){
        return notificationClient.getAllNotifications();
    }

    public NotificationResponse getNotificationById(Long id) throws Exception{
        return notificationClient.getNotificationById(id);
    }

    public List<NotificationResponse> getNotificationByUserId(Long userId){
        return notificationClient.getNotificationByUserId(userId);
    }

    public void updateToReadNotification( Long id){
        notificationClient.updateToReadNotification(id);
    }

}
