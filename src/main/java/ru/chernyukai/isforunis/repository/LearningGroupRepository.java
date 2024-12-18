package ru.chernyukai.isforunis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.chernyukai.isforunis.model.LearningGroup;

public interface LearningGroupRepository extends JpaRepository<LearningGroup, Long> {
    LearningGroup getLearningGroupByName(String name);
}
