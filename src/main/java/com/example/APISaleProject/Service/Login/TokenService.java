package com.example.APISaleProject.Service.Login;



import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.example.APISaleProject.Model.Users.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;


@Service
public class TokenService {
    private static final String TOKEN_KEY = "Imoveis_Sales";
    public LoginResponse generateToken(User user){
        Date date = new Date();
        long unixTime = date.getTime() / 1000L;
        long timeToken = 3600;
        String token = Jwts.builder().setSubject(user.getLogin()).signWith(SignatureAlgorithm.HS512, TOKEN_KEY).setExpiration(new Date(System.currentTimeMillis() + (timeToken * 1000))).compact();
        return new LoginResponse(token, user.getName(), user.getIdentifier(), unixTime + timeToken);

    }



    private Instant dataExpiration() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
