package com.Dhananjay.ChatApplication.Controller;

import com.Dhananjay.ChatApplication.Entity.Message;
import com.Dhananjay.ChatApplication.Payload.MessageRequest;
import com.Dhananjay.ChatApplication.Service.ChatService;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class MessageController {

    private final ChatService chatService;

    public MessageController(ChatService chatService) {
        this.chatService = chatService;
    }

    @MessageMapping("/send/{roomId}")
    @SendTo("/topic/{roomId}")
    public Message sendMessage(
            @DestinationVariable String roomId,
            MessageRequest request) {

        return chatService.sendMessage(request, roomId);
    }

    @GetMapping
    public String chat(){
        return "Join";
    }
}