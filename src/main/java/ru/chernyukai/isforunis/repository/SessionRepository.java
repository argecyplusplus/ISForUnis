package ru.chernyukai.isforunis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.chernyukai.isforunis.model.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
