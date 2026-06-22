package com.rolidev.apirest.utils;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.rolidev.apirest.models.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
    private final Key key= Keys.hmacShaKeyFor("TFXY1Pswu69hS7P1JzFttMnBL8n6ppgDB3hMTj6UXlrBldgUJBYXhvjR9ff".getBytes(StandardCharsets.UTF_8));

    public String generateToken(User user){
        long expirationMillis = 1000 * 60 * 60;

        Date now = new Date();
        Date expiry = new Date(now.getTime() +  expirationMillis);
        return Jwts.builder().subject(user
                             .getEmail())
                             .issuedAt(now)
                             .expiration(expiry)
                             .signWith(key)
                             .compact();
    }
}
