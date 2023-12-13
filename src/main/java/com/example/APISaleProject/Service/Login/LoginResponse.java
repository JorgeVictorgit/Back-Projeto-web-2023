package com.example.APISaleProject.Service.Login;

public class LoginResponse {

    public String token;
    public String name;
    public String identifier;
    public long expires_in;

    public LoginResponse(String token, String name, String identifier, long expires_in) {
        super();
        this.token = token;
        this.name = name;
        this.identifier = identifier;
        this.expires_in = expires_in;
    }
}
