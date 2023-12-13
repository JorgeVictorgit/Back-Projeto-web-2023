package com.example.APISaleProject.Exception.user;

public class UserUnauthorizedException extends UserException {

    public UserUnauthorizedException() {
        super();
    }

    public UserUnauthorizedException(String message) {
        super("UserUnauthorizedException() -> " + message);
    }
}
