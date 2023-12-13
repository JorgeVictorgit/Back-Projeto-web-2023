package com.example.APISaleProject.Exception.user;

public class UserTokenExpired extends UserException {

    public UserTokenExpired() {
        super();
    }
    public UserTokenExpired(String message) {
        super("UserTokenExpired() -> " + message);
    }
}
