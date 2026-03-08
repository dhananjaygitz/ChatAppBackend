package com.Dhananjay.ChatApplication.Controller;


import com.Dhananjay.ChatApplication.Entity.Message;
import com.Dhananjay.ChatApplication.Entity.Room;
import com.Dhananjay.ChatApplication.Service.RoomService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Room")
@CrossOrigin(origins = "*")
public class ChatRoomController {

    private final RoomService roomService;

    public ChatRoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    @PostMapping("/create")
    public Room createRoom(@RequestBody String roomId){
        return roomService.createRoomId(roomId);
    }

    @GetMapping("/join/{roomid}")
    public Room joinRoom(@PathVariable String roomid){
        System.out.println("Trying to join room: " + roomid);
        Room room = roomService.joinRoom(roomid);
        return room;
    }

    @GetMapping("/join/{roomid}/message")
    public List<Message> getMessage(@PathVariable String roomid, @RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                                    @RequestParam(value = "size", defaultValue = "20", required = false) int size){
        List<Message> messages = roomService.getMessage(roomid, page, size);
        return messages;
    }



}
