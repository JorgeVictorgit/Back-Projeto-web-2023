package com.example.APISaleProject.Exception.user;

public class UserException extends Exception {

    public UserException() {
        super();
    }

    public UserException(String message) {
        super("throw: UserException() by: \n - " + message);
    }
}
