package dev.struchkov.filmorate.data.repository;

import dev.strichkov.filmorate.domain.Film;
import dev.strichkov.filmorate.domain.page.Pagination;
import dev.strichkov.filmorate.domain.page.Sheet;
import dev.struchkov.filmorate.context.repository.FilmRepository;
import dev.struchkov.filmorate.data.jpa.FilmJpaRepository;
import dev.struchkov.filmorate.data.mapper.FilmEntityMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FilmRepositoryImpl implements FilmRepository {

    private final FilmJpaRepository jpaRepository;
    private final FilmEntityMapper filmMapper;

    @Override
    public Film save(@NonNull Film film) {
        return filmMapper.toDomain(
                jpaRepository.save(filmMapper.toEntity(film))
        );
    }

    @Override
    public Optional<Film> findById(@NonNull Long filmId) {
        return jpaRepository.findById(filmId)
                .map(filmMapper::toDomain);
    }

    @Override
    public Sheet<Film> findAll(@NonNull Pagination pagination) {
        final PageRequest pageable = PageRequest.of(pagination.getPageNumber(), pagination.getPageSize());
        final Page<Film> page = jpaRepository.findAll(pageable)
                .map(filmMapper::toDomain);
        return Sheet.<Film>builder()
                .totalElements(page.getTotalElements())
                .totalPage(page.getTotalPages())
                .pageNumber(pagination.getPageNumber())
                .pageSize(pagination.getPageSize())
                .content(page.getContent())
                .build();
    }

    @Override
    public void deleteById(@NonNull Long filmId) {
        jpaRepository.deleteById(filmId);
    }

}
