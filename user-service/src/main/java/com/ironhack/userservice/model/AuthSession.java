package com.ironhack.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AuthSession {

        @Id
        @Getter
        @Setter
        @GeneratedValue
        private Long id;
        @Getter
        @Setter
        @ManyToOne
        private User user;
        @Getter
        @Setter
        private String token;

        public AuthSession(User user, String token) {
                this.user = user;
                this.token = token;
        }
}
