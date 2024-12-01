package ru.chernyukai.isforunis.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "AttendanceUnits")
@Table(name = "AttendanceUnits")
public class AttendanceUnit {

    @Id
    @Column(name = "attendance_unit_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attendance_unit_seq")
    @SequenceGenerator(name = "attendance_unit_seq", sequenceName = "attendance_unit_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    private LearningGroup group;

    private Session session;


    //m to m
    private List<Student> studentList;

}
