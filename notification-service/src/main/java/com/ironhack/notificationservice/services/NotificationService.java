package com.ironhack.notificationservice.services;

import com.ironhack.common.dto.event.EventKafka;
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

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }

    public List<Notification> getNotificationByUserId(Long userId) {
        return notificationRepository.getNotificationByUserId(userId);
    }

    public void messageKafka(EventKafka eventKafka) {
        for (int i = 0; i < eventKafka.getAttendees().size(); i++) {
            notificationRepository.save(
                    new Notification(
                            eventKafka.getAttendees().get(i),
                            "The Event " + eventKafka.getTitle() + " has been " + (eventKafka.isDeleted() ? "deleted" : "modified. See you there!"),
                            false
                    )
            );
        }
    }

    public void notificationRead(Long id){
        Optional<Notification> notification = notificationRepository.findById(id);
        if(notification.isPresent()){
            notification.get().setIsRead(true);
            notificationRepository.save(notification.get());
        }
    }
}
