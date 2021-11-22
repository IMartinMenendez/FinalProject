package com.ironhack.edge.clients;

import com.ironhack.common.dto.notifications.NotificationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient("notification-service")
public interface NotificationClient {

    @GetMapping("/Notifications")
    List<NotificationResponse> getAllNotifications();

    @GetMapping("/Notifications/{id}")
    NotificationResponse getNotificationById(@PathVariable Long id) throws Exception;

    @GetMapping("/Notifications/{userId}")
    List<NotificationResponse> getNotificationByUserId(@PathVariable Long userId);
}
