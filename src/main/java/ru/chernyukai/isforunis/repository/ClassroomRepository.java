package ru.chernyukai.isforunis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.chernyukai.isforunis.model.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    Classroom getClassroomByName(String name);
}
