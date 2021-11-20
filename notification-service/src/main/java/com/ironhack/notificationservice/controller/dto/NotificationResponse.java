package com.ironhack.notificationservice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class NotificationResponse {

    @Getter
    @Setter
    private Long userId;
    @Getter
    @Setter
    private String message;
    @Getter
    @Setter
    private Boolean isRead;
}
