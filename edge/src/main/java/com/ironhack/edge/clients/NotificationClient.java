package com.ironhack.edge.clients;

import com.ironhack.common.dto.notifications.NotificationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;


@FeignClient("notification-service")
public interface NotificationClient {

    @GetMapping("/Notifications")
    List<NotificationResponse> getAllNotifications();

    @GetMapping("/Notification/{id}")
    NotificationResponse getNotificationById(@PathVariable Long id) throws Exception;

    @GetMapping("/Notifications/{userId}")
    List<NotificationResponse> getNotificationByUserId(@PathVariable Long userId);

    @PutMapping("/Notifications/{id}")
    @ResponseStatus(HttpStatus.OK)
    void updateToReadNotification(@PathVariable Long id);
}
