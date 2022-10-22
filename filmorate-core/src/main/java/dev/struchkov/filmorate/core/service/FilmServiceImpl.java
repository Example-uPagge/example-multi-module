package dev.struchkov.filmorate.core.service;

import dev.strichkov.filmorate.domain.Film;
import dev.strichkov.filmorate.domain.page.Pagination;
import dev.strichkov.filmorate.domain.page.Sheet;
import dev.struchkov.filmorate.context.Message;
import dev.struchkov.filmorate.context.repository.FilmRepository;
import dev.struchkov.filmorate.context.service.FilmService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

import static dev.struchkov.filmorate.context.exception.NotFoundException.notFoundException;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final FilmRepository repository;

    @Override
    @Transactional
    public Film create(@NonNull Film film) {
        film.setDateCreated(film.getDateCreated());
        return repository.save(film);
    }

    @Override
    @Transactional
    public Film update(@NonNull Film newFilm) {
        final Film oldFilm = repository.findById(newFilm.getId())
                .orElseThrow(notFoundException(Message.NotFound.FILM, newFilm.getId()));
        oldFilm.setName(newFilm.getName());
        oldFilm.setDurationInMinutes(newFilm.getDurationInMinutes());
        oldFilm.setDateRelease(newFilm.getDateRelease());
        oldFilm.setDescription(newFilm.getDescription());
        oldFilm.setDateUpdated(LocalDateTime.now());
        return oldFilm;
    }

    @Override
    public void deleteById(@NonNull Long filmId) {
        repository.deleteById(filmId);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Film> getById(@NonNull Long filmId) {
        return repository.findById(filmId);
    }

    @Override
    @Transactional(readOnly = true)
    public Film getByIdOrThrow(@NonNull Long filmId) {
        return repository.findById(filmId)
                .orElseThrow(notFoundException(Message.NotFound.FILM, filmId));
    }

    @Override
    @Transactional(readOnly = true)
    public Sheet<Film> getAll(@NonNull Pagination pagination) {
        return repository.findAll(pagination);
    }

}
