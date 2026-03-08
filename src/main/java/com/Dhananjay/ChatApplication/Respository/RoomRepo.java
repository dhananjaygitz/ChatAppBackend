package com.Dhananjay.ChatApplication.Respository;

import com.Dhananjay.ChatApplication.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepo extends JpaRepository<Room,Long> {

    Room findByRoomId(String roomID);

}
