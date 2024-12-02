package ru.chernyukai.isforunis.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "Chats")
@Table(name = "Chats")
public class Chat {

    @Id
    @Column(name = "chat_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chat_seq")
    @SequenceGenerator(name = "chat_seq", sequenceName = "chat_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "user1",
            nullable = false
    )
    private User user1;

    @ManyToOne
    @JoinColumn(
            name = "user2",
            nullable = false
    )
    private User user2;


}
