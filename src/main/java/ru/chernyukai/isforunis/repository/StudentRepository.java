package ru.chernyukai.isforunis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.chernyukai.isforunis.model.LearningGroup;
import ru.chernyukai.isforunis.model.Student;
import ru.chernyukai.isforunis.model.User;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student getStudentByUser(User user);

    @Query(name = "select * from students where is_headman == true and group = group.id", nativeQuery = true)
    Student getHeadmanByGroup (LearningGroup group);

}
