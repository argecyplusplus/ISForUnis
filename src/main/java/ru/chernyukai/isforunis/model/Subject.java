package ru.chernyukai.isforunis.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "Subjects")
@Table(name = "Subjects")
public class Subject {
    @Id
    @Column(name = "subject_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(
            name = "cathedra",
            foreignKey = @ForeignKey(
                    name = "fk_cathedra",
                    foreignKeyDefinition = "FOREIGN KEY (cathedra) REFERENCES Cathedras(cathedra_id) ON DELETE SET NULL"
            )
    )
    private Cathedra cathedra;
}
