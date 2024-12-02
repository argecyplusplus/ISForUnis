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
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(
            name = "user"
    )
    private User user;

    @ManyToOne
    @JoinColumn(
            name = "group",
            foreignKey = @ForeignKey(name = "fk_student_group", foreignKeyDefinition = "FOREIGN KEY (group) REFERENCES Groups(group_id) ON DELETE SET NULL")
    )
    private LearningGroup group;

    @Column(name = "is_headman", nullable = false)
    private boolean isHeadman;

    @Column (name = "grade_nook_number", nullable = false)
    private String gradeBookNumber;


}
