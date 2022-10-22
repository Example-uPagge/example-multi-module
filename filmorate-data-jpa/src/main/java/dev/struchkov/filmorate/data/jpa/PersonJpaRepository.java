package dev.struchkov.filmorate.data.jpa;

import dev.struchkov.filmorate.data.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonJpaRepository extends JpaRepository<PersonEntity, Long> {
}
