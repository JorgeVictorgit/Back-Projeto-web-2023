package com.example.APISaleProject.Service.Token;

import io.jsonwebtoken.*;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.GenericFilterBean;


import java.io.IOException;

public class TokenFilter extends GenericFilterBean {

    public final static int TOKEN_INDEX = 7;



    @Override
    public void doFilter(ServletRequest request, ServletResponse response ,FilterChain chain) throws IOException, ServletException {
        HttpServletRequest requestAux = (HttpServletRequest) request;
        String header = requestAux.getHeader("Authorization");
        if(header == null || !header.startsWith("Bearer ")) {
            throw new ServletException("Token does not exist!");
        }

        String token = header.substring(TOKEN_INDEX);

        try {
            Jwts.parser().setSigningKey("DefaultUserLogin").parseClaimsJws(token).getBody().getSubject();
        } catch (SignatureException | ExpiredJwtException | MalformedJwtException | PrematureJwtException | UnsupportedJwtException | IllegalArgumentException err) {
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, err.getMessage());
            return;
        }

        chain.doFilter(request, response);
    }
}
