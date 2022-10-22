package dev.struchkov.filmorate.context.service;

import dev.strichkov.filmorate.domain.Film;
import dev.strichkov.filmorate.domain.page.Pagination;
import dev.strichkov.filmorate.domain.page.Sheet;
import lombok.NonNull;

import java.util.Optional;

public interface FilmService {

    Film create(@NonNull Film film);

    Film update(@NonNull Film film);

    void deleteById(@NonNull Long filmId);

    Optional<Film> getById(@NonNull Long filmId);

    Film getByIdOrThrow(@NonNull Long filmId);

    Sheet<Film> getAll(@NonNull Pagination pagination);

}
