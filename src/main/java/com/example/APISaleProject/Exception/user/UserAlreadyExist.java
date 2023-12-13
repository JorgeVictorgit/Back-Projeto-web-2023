package com.example.APISaleProject.Exception.user;

public class UserAlreadyExist extends UserException{
    public UserAlreadyExist() {
        super();
    }

    public UserAlreadyExist(String message) {
        super("UserAlreadyExist() -> " + message);
    }
}
