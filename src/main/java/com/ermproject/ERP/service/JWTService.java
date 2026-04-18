package com.ermproject.ERP.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JWTService {

    private static final String SECRET_KEY = "nossa-chave-muito-secreta-abcdef-5667";

    public Key getSignKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String generateToken(String username) {
        return Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(new Date(
                System.currentTimeMillis() + 1000 * 60 * 60)).signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }

    public String validateToken(String token) {
        return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody().getSubject();
    }
}
