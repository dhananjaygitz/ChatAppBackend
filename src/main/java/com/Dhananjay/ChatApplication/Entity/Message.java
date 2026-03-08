package com.Dhananjay.ChatApplication.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String sender;
    private String content;

    @ManyToOne
    @JoinColumn(name = "room_id")
    @JsonBackReference
    private Room room;  // FK to Room.id
}