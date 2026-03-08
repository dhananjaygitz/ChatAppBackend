package com.Dhananjay.ChatApplication.Service;


import com.Dhananjay.ChatApplication.Entity.Message;
import com.Dhananjay.ChatApplication.Entity.Room;
import com.Dhananjay.ChatApplication.Payload.MessageRequest;
import com.Dhananjay.ChatApplication.Respository.MessageRepo;
import com.Dhananjay.ChatApplication.Respository.RoomRepo;
import org.springframework.stereotype.Service;



@Service
public class ChatService {

    private RoomRepo roomRepo;
    private MessageRepo messageRepo;

    public ChatService(RoomRepo roomRepo, MessageRepo messageRepo ) {
        this.roomRepo = roomRepo;
        this.messageRepo = messageRepo;

    }


    public Message sendMessage(MessageRequest request, String roomId ){
        Room byRoomId = roomRepo.findByRoomId(roomId);
        if (byRoomId==null) throw  new RuntimeException("No Room Found");
        Message message = new Message();
        message.setContent(request.getContent());
        message.setRoom(byRoomId);
        message.setSender(request.getSender());
        byRoomId.getMessages().add(message);
        return messageRepo.save(message);
    }

}
