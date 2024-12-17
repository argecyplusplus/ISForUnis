package ru.chernyukai.isforunis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.chernyukai.isforunis.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
