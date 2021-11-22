package com.ironhack.notificationservice.services;

import com.ironhack.notificationservice.models.Notification;
import com.ironhack.notificationservice.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    public List<Notification> getAllNotifications(){
        return notificationRepository.findAll();
    }

    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }

    public List<Notification> getNotificationByUserId(Long userId) {
        return notificationRepository.getNotificationByUserId(userId);
    }
}
