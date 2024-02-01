package com.example.blessingchess.service;

import com.example.blessingchess.data.po.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoginService {

    protected String getToken(User user) {
        String token="";
        token= JWT.create()
                .withKeyId(user.getId())
                .withIssuer("www.ikertimes.com")
                .withIssuedAt(new Date())
                .withJWTId("jwt.ikertimes.com")
                .withClaim("session_key", user.getSessionKey())
                .withAudience(user.getId())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

}
