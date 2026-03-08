package com.Dhananjay.ChatApplication.Respository;

import com.Dhananjay.ChatApplication.Entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepo extends JpaRepository<Message, Long> {

    List<Message> findByRoom_RoomId(String roomId);

}
