package dev.struchkov.filmorate.data.repository;

import dev.strichkov.filmorate.domain.Film;
import dev.strichkov.filmorate.domain.page.Pagination;
import dev.strichkov.filmorate.domain.page.Sheet;
import dev.struchkov.filmorate.context.repository.FilmRepository;
import lombok.NonNull;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class FilmLocalRepository implements FilmRepository {

    private final Map<Long, Film> storage = new HashMap<>();
    private long gen = 0;

    @Override
    public Film save(@NonNull Film film) {
        film.setId(gen++);
        storage.put(film.getId(), film);
        return film;
    }

    @Override
    public Optional<Film> findById(@NonNull Long filmId) {
        return Optional.ofNullable(storage.get(filmId));
    }

    @Override
    public Sheet<Film> findAll(@NonNull Pagination pagination) {
        throw new UnsupportedOperationException("Не работает :(");
    }

    @Override
    public void deleteById(@NonNull Long filmId) {
        storage.remove(filmId);
    }

}
