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

    @ManyToOne
    @JoinColumn(
            name = "group",
            foreignKey = @ForeignKey(
                    name = "fk_learning_group",
                    foreignKeyDefinition = "FOREIGN KEY (group) REFERENCES Groups(group_id) ON DELETE CASCADE"
            ), nullable = false
    )
    private LearningGroup group;

    @ManyToOne
    @JoinColumn(
            name = "session",
            foreignKey = @ForeignKey(
                    name = "fk_session",
                    foreignKeyDefinition = "FOREIGN KEY (session) REFERENCES Sessions(session_id) ON DELETE CASCADE"
            ), nullable = false
    )
    private Session session;

    @ManyToMany
    @JoinTable(
            name = "StudentAttendanceUnits",
            joinColumns = @JoinColumn(
                    name = "attendance_unit_id",
                    foreignKey = @ForeignKey(
                            name = "fk_attendance_unit_student",
                            foreignKeyDefinition = "FOREIGN KEY (attendance_unit_id) REFERENCES AttendanceUnits(attendance_unit_id) ON DELETE CASCADE"
                    )
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    foreignKey = @ForeignKey(
                            name = "fk_student_attendance_unit",
                            foreignKeyDefinition = "FOREIGN KEY (student_id) REFERENCES Students(student_id) ON DELETE CASCADE"
                    )
            )
    )
    private List<Student> studentList;

}
