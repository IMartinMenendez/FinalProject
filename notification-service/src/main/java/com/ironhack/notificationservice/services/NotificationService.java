package com.ironhack.notificationservice.services;

import com.ironhack.notificationservice.controller.dto.NotificationResponse;
import com.ironhack.notificationservice.models.Notification;
import com.ironhack.notificationservice.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    public List<NotificationResponse> getAllNotifications(){
        List<Notification> notifications = notificationRepository.findAll();
        List<NotificationResponse> notificationResponses = new ArrayList<>();
        for (Notification notification : notifications) {
            new NotificationResponse(notification.getUserId(), notification.getMessage(), notification.getIsRead());
        }
        return notificationResponses;
    }

    public NotificationResponse getNotificationById(Long id) throws Exception {
        Optional<Notification> maybeNotification = notificationRepository.findById(id);
        if(maybeNotification.isEmpty()){
            throw new Exception("No Notification found");
        }
        return new NotificationResponse(maybeNotification.get().getUserId(), maybeNotification.get().getMessage(), maybeNotification.get().getIsRead());

    }

    public List<NotificationResponse> getNotificationByUserId(Long userId) {
        List<Notification> notifications = notificationRepository.getNotificationByUserId(userId);
        List<NotificationResponse> notificationResponses = new ArrayList<>();
        for (Notification notification : notifications) {
            new NotificationResponse(notification.getUserId(), notification.getMessage(), notification.getIsRead());
        }
        return notificationResponses;
    }
}
