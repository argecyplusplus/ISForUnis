package ru.chernyukai.isforunis.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "Sessions")
@Table(name = "Sessions")
public class Session {
    @Id
    @Column(name = "session_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "session_seq")
    @SequenceGenerator(name = "session_seq", sequenceName = "session_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "subject", nullable = false
    )
    private Subject subject;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    @Column(name = "start_datetime", nullable = false)
    private LocalTime startDatetime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    @Column(name = "duration", nullable = false)
    private LocalTime duration;

    @ManyToOne
    @JoinColumn(
            name = "professor",
            nullable = false
    )
    private User professor;

    @ManyToOne
    @JoinColumn(
            name = "classroom",
            nullable = false
    )
    private Classroom classroom;

    @ManyToMany
    @JoinTable(
            name = "SessionGroups",
            joinColumns = @JoinColumn(
                    name = "session_id",
                    foreignKey = @ForeignKey(
                            name = "fk_session_learning_group",
                            foreignKeyDefinition = "FOREIGN KEY (session_id) REFERENCES Sessions(session_id) ON DELETE CASCADE"
                    )
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "group_id",
                    foreignKey = @ForeignKey(
                            name = "fk_learning_group_session",
                            foreignKeyDefinition = "FOREIGN KEY (group_id) REFERENCES Groups(group_id) ON DELETE CASCADE"
                    )
            )
    )
    private List<LearningGroup> learningGroupList;

}
