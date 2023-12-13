package com.example.APISaleProject.Service.Token;

import com.example.APISaleProject.Exception.user.UserException;
import com.example.APISaleProject.Exception.user.UserTokenBadlyFormattedException;
import com.example.APISaleProject.Model.Users.User;
import com.example.APISaleProject.Service.Users.UserService;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

@Service
public class JWTService {
    private static final String TOKEN_KEY = "Imoveis_Sales";

    private UserService usersService;

    public JWTService(UserService usersService) {

        super();
        this.usersService = usersService;
    }

    public void userExists(String authorizationHeader) throws UserException {
        System.out.println(authorizationHeader);
        String subject = getUserDoToken(authorizationHeader);
        User user = usersService.searchByEmail(subject);
    }

    public String getUserDoToken(String authorizationHeader) throws UserException {
        if(authorizationHeader == null || !authorizationHeader.startsWith("Bearer "))
            throw new UserTokenBadlyFormattedException("Badly formatted token.");

        String token = authorizationHeader.substring(TokenFilter.TOKEN_INDEX);
        String subject = null;
        System.out.println(token);
        System.out.println(subject);

        try {
            subject = Jwts.parser().setSigningKey("Imoveis_Sales").parseClaimsJws(token).getBody().getSubject();
            System.out.println(subject);
            usersService.searchByEmail(subject);
        } catch (Exception err) {
            throw new UserTokenBadlyFormattedException("Badly formatted token.");
        }

        return subject;
    }
    public boolean isCliente(String email) throws UserException {

        User user = usersService.searchByEmail(email);
        try {
            user.getIdentifier().equals("C");;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isVendedor(String email) throws UserException {

        User user = usersService.searchByEmail(email);
        try {
            user.getIdentifier().equals("V");;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
