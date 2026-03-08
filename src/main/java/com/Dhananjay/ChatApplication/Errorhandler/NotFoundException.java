package com.Dhananjay.ChatApplication.Errorhandler;



public class NotFoundException extends RuntimeException{

    public NotFoundException(String message) {
        super(message);
    }
}
