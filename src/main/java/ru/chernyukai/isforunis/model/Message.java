package ru.chernyukai.isforunis.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "Messages")
@Table(name = "Messages")
public class Message {

    @Id
    @Column(name = "message_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_seq")
    @SequenceGenerator(name = "message_seq", sequenceName = "message_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    private String text;

    private DateTime dateTime;

    private Chat chat;

    private Message replyedMEssage;

    private boolean readStatus;

    private User receiver;


}
