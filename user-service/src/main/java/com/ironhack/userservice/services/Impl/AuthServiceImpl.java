package com.ironhack.userservice.services.Impl;

import com.ironhack.userservice.model.AuthSession;
import com.ironhack.userservice.model.User;
import com.ironhack.userservice.repository.AuthSessionRepository;
import com.ironhack.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.security.SecureRandom;
import java.util.Base64;
import java.util.Optional;

@Service
public class AuthServiceImpl {

    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();


    @Autowired
    private AuthSessionRepository authSessionRepository;

    @Autowired
    private UserRepository userRepository;

    public String login(String email, String password) throws Exception {
        Optional<User> maybeUser = userRepository.getUserByEmail(email);
        if (maybeUser.isEmpty()) {
            throw new Exception("User doesn't exist");

        } else if (maybeUser.get().getPassword().equals(password)) {
            String token = generateNewToken();
            AuthSession authSession = new AuthSession(maybeUser.get(), token);
            authSessionRepository.save(authSession);
            return token;
        }

        throw new Exception("Password incorrect");
    }

    @Transactional
    public void logout(String token) {
        authSessionRepository.deleteAuthSessionByToken(token);
    }

    public Long getUserIdByToken(String token) throws Exception {
        Optional<Long> maybeResult = authSessionRepository.getUserIdByToken(token);
        if(maybeResult.isEmpty()){
            throw new Exception("No User for this token");
        }
        return maybeResult.get();
    }

    public static String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }

}
