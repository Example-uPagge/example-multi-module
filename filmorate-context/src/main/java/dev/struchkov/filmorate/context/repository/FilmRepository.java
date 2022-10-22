package dev.struchkov.filmorate.context.repository;

import dev.strichkov.filmorate.domain.Film;
import dev.strichkov.filmorate.domain.page.Pagination;
import dev.strichkov.filmorate.domain.page.Sheet;
import lombok.NonNull;

import java.util.Optional;

public interface FilmRepository {

    Film save(@NonNull Film film);

    Optional<Film> findById(@NonNull Long filmId);

    Sheet<Film> findAll(@NonNull Pagination pagination);

    void deleteById(@NonNull Long filmId);

}
