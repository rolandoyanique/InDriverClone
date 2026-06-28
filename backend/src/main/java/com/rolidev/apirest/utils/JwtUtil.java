package com.rolidev.apirest.utils;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.UserDetails;
import com.rolidev.apirest.models.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
    private final SecretKey key= Keys.hmacShaKeyFor("TFXY1Pswu69hS7P1JzFttMnBL8n6ppgDB3hMTj6UXlrBldgUJBYXhvjR9ff".getBytes(StandardCharsets.UTF_8));

    private Claims getClaims(String token){
        return Jwts.parser()
                   .verifyWith(key)
                   .build()
                   .parseSignedClaims(token)
                   .getPayload();
    }

    public String extractUsername(String token){
        return getClaims(token).getSubject();
    }

    private boolean isTokenExpired(String token){
        return getClaims(token).getExpiration().before(new Date());
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

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
