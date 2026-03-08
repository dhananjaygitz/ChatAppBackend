package com.Dhananjay.ChatApplication.Errorhandler;

public class RoomAlreadyExist extends RuntimeException{

    public RoomAlreadyExist(String message) {
        super(message);
    }
}
