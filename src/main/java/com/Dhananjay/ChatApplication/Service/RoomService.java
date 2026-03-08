package com.Dhananjay.ChatApplication.Service;


import com.Dhananjay.ChatApplication.Entity.Message;
import com.Dhananjay.ChatApplication.Entity.Room;
import com.Dhananjay.ChatApplication.Errorhandler.NotFoundException;
import com.Dhananjay.ChatApplication.Errorhandler.RoomAlreadyExist;
import com.Dhananjay.ChatApplication.Respository.RoomRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private RoomRepo roomRepo;


    public RoomService(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    public Room createRoomId(String roomId){
        if(roomRepo.findByRoomId(roomId)!=null) throw new RoomAlreadyExist("Room is Already exist");
        Room room = new Room();
        room.setRoomId(roomId);
        return roomRepo.save(room);
    }

    public Room joinRoom(String roomId){
        Room byRoomId = roomRepo.findByRoomId(roomId);
        if (byRoomId==null) throw new NotFoundException("Room Not Found");
        return byRoomId;
    }


    public List<Message> getMessage(String roomId,int page, int size){
        Room room = roomRepo.findByRoomId(roomId);
        if (room == null) throw new RuntimeException("NO room exist");
        List<Message> messages = room.getMessages();
        int start = Math.max(0, messages.size() - (page + 1) * size);
        int end = Math.min(messages.size(), start + size);
        return messages.subList(start, end);
    }

}
