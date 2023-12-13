package com.example.APISaleProject.Exception.user;

public class UserNotFoundException extends UserException {

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super("UserNotFoundException() -> " + message);
    }
}
