package ru.chernyukai.isforunis.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

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

    @Column (name ="text", nullable = false)
    private String text;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(
            name = "chat", nullable = false
    )
    private Chat chat;

    @ManyToOne
    @JoinColumn(
            name = "replyed_message"
    )
    private Message replyedMessage;

    @Column(name = "read_status", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean readStatus;

    @ManyToOne
    @JoinColumn(
            name = "receiver", nullable = false
    )
    private User receiver;


}
