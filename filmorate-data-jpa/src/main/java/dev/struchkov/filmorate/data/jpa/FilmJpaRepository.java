package dev.struchkov.filmorate.data.jpa;

import dev.struchkov.filmorate.data.entity.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmJpaRepository extends JpaRepository<FilmEntity, Long> {
}
