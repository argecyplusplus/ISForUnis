package ru.chernyukai.isforunis.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "Groups")
@Table(name = "Groups")
public class LearningGroup {
    @Id
    @Column(name = "group_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_seq")
    @SequenceGenerator(name = "group_seq", sequenceName = "group_seq", initialValue = 1, allocationSize = 1)
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

    @Column(name = "specialization", nullable = false)
    private String specialization;




}
