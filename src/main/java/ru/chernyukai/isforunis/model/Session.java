package ru.chernyukai.isforunis.model;

import jakarta.persistence.*;
import lombok.*;

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


    private Subject subject;

    @Column(name = "start_datetime")
    private Time startDatetime;

    @Column(name = "duration")
    private Time duration;


    private User professor;


    private Classroom classroom;

    private List<LearningGroup> learningGroupList;

}
