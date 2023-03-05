package com.udit.blogapplication.config;


import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    private String jwtSingingKey = "secret";

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    public boolean hasClaims(String token, String claimName){
        final Claims claims = extractAllClaims(token);
        return claims.get(claimsName) != null;
    }
}
