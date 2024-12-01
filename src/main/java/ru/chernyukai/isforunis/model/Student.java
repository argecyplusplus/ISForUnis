package ru.chernyukai.isforunis.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "Students")
@Table(name = "Students")
public class Student {
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(name = "student_seq", sequenceName = "student_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    //1 to 1
    private User user;

    private LearningGroup group;

    private boolean isHeadman;

    private String gradeBookNumber;


}
