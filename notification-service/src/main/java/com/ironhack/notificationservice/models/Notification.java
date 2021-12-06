package com.ironhack.notificationservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id
    @Getter
    @Setter
    @GeneratedValue
    private Long id;
    @Getter
    @Setter
    private Long userId;
    @Getter
    @Setter
    private String message;
    @Getter
    @Setter
    private Boolean isRead;

    public Notification(Long userId, String message, Boolean isRead) {
        this.userId = userId;
        this.message = message;
        this.isRead = isRead;
    }
}
