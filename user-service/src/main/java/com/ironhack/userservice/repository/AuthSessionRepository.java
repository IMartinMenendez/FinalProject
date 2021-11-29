package com.ironhack.userservice.repository;

import com.ironhack.userservice.model.AuthSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthSessionRepository extends JpaRepository<AuthSession, Long> {

    @Query("select a.user.id from AuthSession a where a.token = :token")
    Optional<Long> getUserIdByToken(String token);

    void deleteAuthSessionByToken(String token);
}
