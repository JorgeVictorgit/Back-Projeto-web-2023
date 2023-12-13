package com.example.APISaleProject.Exception.user;

public class UserTokenBadlyFormattedException extends UserException {

    public UserTokenBadlyFormattedException() {
        super();
    }

    public UserTokenBadlyFormattedException(String message) {
        super("UserTokenBadlyFormattedException() -> " + message);
    }
}
