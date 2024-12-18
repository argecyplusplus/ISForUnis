package ru.chernyukai.isforunis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.chernyukai.isforunis.model.Student;
import ru.chernyukai.isforunis.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject getSubjectsByName(String name);
}
