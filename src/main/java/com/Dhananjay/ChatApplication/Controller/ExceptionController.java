package com.Dhananjay.ChatApplication.Controller;

import com.Dhananjay.ChatApplication.Errorhandler.NotFoundException;
import com.Dhananjay.ChatApplication.Errorhandler.RoomAlreadyExist;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(RoomAlreadyExist.class)
    public ResponseEntity<String> roomAlreadyExist(RoomAlreadyExist roomAlreadyExist){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(roomAlreadyExist.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> roomNotFound(NotFoundException notFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundException.getMessage());
    }
}
